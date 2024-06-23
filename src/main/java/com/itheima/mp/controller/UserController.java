package com.itheima.mp.controller;


import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    //前端发送请求，请求路径为user/getAllUser
    @GetMapping("/getAllUser")
    public Result getAllUser(){
        log.info("查询所有用户信息");
        List<User> userList = userService.list();
        return Result.success(userList);
    }

   //根据ID删除用户
    @DeleteMapping("/deleteUserById/{id}")
    public Result deleteUserById(@PathVariable("id") Integer id){
        log.info("根据ID删除用户信息:{}",id);
        userService.removeById(id);
        return Result.success();
    }
    //通过Excel批量导入用户信息
    @PostMapping("/importUsers")
    public Result importUsers(@RequestParam("file") MultipartFile file) {
        log.info("通过Excel批量导入用户信息");
        if (file.isEmpty()) {
            return Result.error("文件为空");
        }
        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            List<User> userList = new ArrayList<>();
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { // 跳过表头
                    continue;
                }
                try {
                    User user = new User();
                    // 根据单元格类型和内容进行安全读取
                    user.setUserId((int) getNumericCellValue(row.getCell(0)));
                    user.setUserName(getStringCellValue(row.getCell(1)));
                    user.setUserGender(getNumericCellValue(row.getCell(2)) == 1 ? "男" : "女");
                    user.setUserPhone(getStringCellValue(row.getCell(3)));
                    user.setUserIdCard(getStringCellValue(row.getCell(4)));
                    user.setUserIsVerified(getBooleanCellValue(row.getCell(5)));
                    user.setUserAccount(getStringCellValue(row.getCell(6)));
                    user.setUserPassword(getStringCellValue(row.getCell(7)));
                    user.setUserLocation(getStringCellValue(row.getCell(8)));
                    userList.add(user);
                } catch (Exception e) {
                    log.error("Error processing row number: " + row.getRowNum(), e);
                    return Result.error("数据解析失败");
                }
            }
            userService.saveAll(userList);
            return Result.success();
        } catch (IOException e) {
            log.error("文件读取失败", e);
            return Result.error("导入失败");
        }
    }
    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        return cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.toString();
    }
    private double getNumericCellValue(Cell cell) {
        if (cell == null) {
            return 0;
        }
        return cell.getCellType() == CellType.NUMERIC ? cell.getNumericCellValue() : 0;
    }
    private boolean getBooleanCellValue(Cell cell) {
        if (cell == null) {
            return false;
        }
        return cell.getCellType() == CellType.BOOLEAN ? cell.getBooleanCellValue() : Boolean.parseBoolean(cell.toString());
    }

}


