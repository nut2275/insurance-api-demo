package com.example.test.insuranceapi.insuranceapi;

// 1. นำเข้าเครื่องมือสำหรับจัดการ Database (JPA)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 2. นำเข้าเครื่องมือจาก Lombok (ตัวช่วยขี้เกียจ)
import lombok.Data;

@Data // สั่งให้มันแอบสร้าง getter/setter ให้อัตโนมัติหลังบ้าน โค้ดเลยสั้นนิดเดียว
@Entity // คลาสนี้คือ Table ใน Database นะ

public class Insurance {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ให้ Database รันเลข Auto ให้หน่อย" (1, 2, 3...) เราไม่ต้องใส่มือเอง
    private Long id; // gen id auto

    private String policyName; //ชื่อประกัน วิริยประกันภัย, ธนชาตประกันภัย
    private Double price; //ราคา
    private String type; //ประเภท เช่น รถยนต์, สุขภาพ
}
