//package com.sleevesup.settleupkotlin.controller
//
//import com.sleevesup.settleupkotlin.DTO.ExpenseDto
//import com.sleevesup.settleupkotlin.service.ExpenseInterface
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//
//@RestController
//@RequestMapping("api/v1")
//class ExpenseController(private val expense:ExpenseInterface) {
//
//    @PostMapping("/addexpense")
//    fun addexpense(@RequestBody expenseAdd:ExpenseDto):ResponseEntity<Any>{
//        var result = expense.addGroup(expenseAdd)
//        return ResponseEntity.ok(result)
//    }
//}