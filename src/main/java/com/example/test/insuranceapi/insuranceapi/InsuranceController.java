package com.example.test.insuranceapi.insuranceapi;

// 1. นำเข้าตัวช่วยเรื่อง Dependency Injection (การเชื่อมต่อของอัตโนมัติ)
import org.springframework.beans.factory.annotation.Autowired;
// 2. นำเข้าเครื่องมือสร้าง REST API ทั้งหมด
import org.springframework.web.bind.annotation.*;
import java.util.List;

// ของ import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/insurances")

public class InsuranceController {
    @Autowired // เชื่อมต่อกับ Repository อัตโนมัติ (Spring จัดการให้ ไม่ต้อง new เอง)
    private InsuranceRepository insuranceRepository;

    @GetMapping
    public List<Insurance> getAllInsurances() {
        //SELECT id, policy_name, price, type FROM insurance;
        return insuranceRepository.findAll();
    }
    @PostMapping
    public Insurance createInsurance(@RequestBody Insurance insurance){
        //INSERT INTO insurance (policy_name, price, type) VALUES (?, ?, ?);
        return insuranceRepository.save(insurance);
    }

    @GetMapping("/{id}")
    public Insurance getInsuranceById(@PathVariable Long id) {
        // .findById จะคืนค่ามาเป็น Optional (กล่องสุ่ม)
        // .orElse(null) แปลว่า "ถ้าเปิดกล่องแล้วไม่เจอข้อมูล ให้ส่งค่า null กลับไป"
        return insuranceRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Insurance updateInsurance(@PathVariable Long id, @RequestBody Insurance insuranceDetails){
        return insuranceRepository.findById(id).map(insurance -> {
            // ถ้าเจอ: ให้เอารายละเอียดใหม่ มาทับตัวเก่า
            insurance.setPolicyName(insuranceDetails.getPolicyName());
            insurance.setPrice(insuranceDetails.getPrice());
            insurance.setType(insuranceDetails.getType());
            // บันทึกลง Database (ถ้า ID เดิม = อัปเดต, ถ้า ID ใหม่ = สร้างใหม่)
            return insuranceRepository.save(insurance);
        }).orElse(null); // ถ้าหา ID ไม่เจอ ก็ไม่ทำอะไร
    }

    @DeleteMapping("/{id}")
    public String deleteInsurance(@PathVariable Long id){
        insuranceRepository.deleteById(id);
        return "ลบข้อมูล ID: " + id + "เรียบร้อย";
    }
}
