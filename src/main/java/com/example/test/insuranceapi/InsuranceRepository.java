package com.example.test.insuranceapi;

// 1. นำเข้าคลาสแม่ที่เป็นต้นแบบการติดต่อ Database
import org.springframework.data.jpa.repository.JpaRepository;
// 2. นำเข้าตัวบอกว่านี่คือ Component ประเภท Repository
import org.springframework.stereotype.Repository;

@Repository //ไฟล์สำหรับคุยกับ Database 
//ID ของมันเป็นประเภท Long (ตัวเลข)
// .save(), .findById(), .findAll(), .delete()
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    
}
