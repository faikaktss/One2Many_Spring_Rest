# 🔗 One2Many_Spring_Rest

Merhaba!  
Bu proje, **Spring Boot** ve **Spring Data JPA** kullanarak hem bire bir (one-to-one) hem de bire-çok (one-to-many) ilişkili varlıklar için modern, profesyonel ve katmanlı bir RESTful API örneğidir.  
DTO, validasyon, global hata yönetimi ve sürdürülebilir mimari ile kurumsal düzeyde, ilişkisel veri modellemenin en iyi uygulamalarını sunar.

---

## 🚀 Özellikler

- 🔄 **One-to-One ve One-to-Many Entity İlişkileri:**  
  - **One-to-One:** Customer–Address, Student gibi birebir ilişkiler.
  - **One-to-Many:** Home–Room ilişkisiyle bir evin birden fazla odası olabilir.
- 📦 **DTO Kullanımı:**  
  Tüm veri alışverişlerinde DTO’lar ile güvenli ve sade transfer.
- 💾 **Spring Data JPA ile CRUD:**  
  Entity’ler için otomatik repository ve veritabanı işlemleri.
- 🧩 **Katmanlı Mimari ve Temiz Kod:**  
  Controller, Service, Repository, DTO, Entity ve Exception katmanları.
- ✅ **Validasyon & Hata Yönetimi:**  
  Alan doğrulama (@Valid, @NotNull, @Email, @Size…) ve merkezi exception handler.
- 🛡️ **Kurumsal Seviye Prensipler:**  
  Açıklamalı, sürdürülebilir ve ölçeklenebilir kod yapısı.

---

## 🏗️ Proje Mimarisi

```
src/main/java/com/faik/
├── Controller/
│   ├── Impl/
│   │   ├── StudentControllerImpl.java
│   │   ├── CustomerControllerImpl.java
│   │   ├── AddressControllerImpl.java
│   │   └── HomeController.java
│   ├── IStudentController.java
│   ├── ICustomerController.java
│   ├── IAddressController.java
│   └── IHomeController.java
│
├── Services/
│   ├── Impl/
│   │   ├── StudentServiceImpl.java
│   │   ├── CustomerService.java
│   │   ├── AddressServiceImpl.java
│   │   └── HomeServiceImpl.java
│   ├── IStudentService.java
│   ├── ICustomerService.java
│   ├── IAddressService.java
│   └── IHomeServices.java
│
├── Repository/
│   ├── StudentRepository.java
│   ├── CustomerRepository.java
│   ├── AddressRepository.java
│   └── HomeRepository.java
│
├── Entites/
│   ├── Student.java
│   ├── Customer.java
│   ├── Address.java
│   ├── Home.java          # (One-to-Many: List<Room>)
│   └── Room.java          # (Many-to-One: Home)
│
├── dto/
│   ├── DtoStudent.java
│   ├── DtoStudentIU.java
│   ├── DtoCustomer.java
│   ├── DtoAddress.java
│   ├── DtoHome.java       # (Home DTO’su, rooms listesi ile)
│   └── DtoRoom.java       # (Room DTO’su)
│
├── exception/
│   ├── ApiError.java
│   └── GlobalExecptionHandler.java
│
└── Starter/
    └── Application.java
```

---

## 🔗 Entity İlişkileri

### 🟢 One-to-One  
- **Customer** ↔ **Address**  
  Her müşteri için bir adres, her adres için bir müşteri tutulur.

### 🟦 One-to-Many  
- **Home** ➡️ **Room**  
  Bir evin birden fazla odası olabilir; Home entity’sinde `List<Room>` ile ifade edilir.

---

## 🛣️ API Endpointleri

### Student API (`/rest/api/student`)
| Metot | Endpoint                        | Açıklama                        |
|-------|---------------------------------|---------------------------------|
| POST  | `/save`                         | Yeni öğrenci ekler              |
| GET   | `/list`                         | Tüm öğrencileri listeler        |
| GET   | `/list/{id}`                    | Belirli öğrenciyi getirir       |
| PUT   | `/update/{id}`                  | Öğrenci günceller               |
| GET   | `/delete/{id}`                  | Öğrenci siler                   |

### Customer API (`/rest/api/customer`)
| Metot | Endpoint            | Açıklama                |
|-------|---------------------|-------------------------|
| GET   | `/list/{id}`        | ID ile müşteri getirir  |

### Address API (`/rest/api/address`)
| Metot | Endpoint            | Açıklama                |
|-------|---------------------|-------------------------|
| GET   | `/list/{id}`        | ID ile adres getirir    |

### Home API (`/rest/api/home`)
| Metot | Endpoint         | Açıklama                          |
|-------|------------------|-----------------------------------|
| GET   | `/{id}`          | Evin bilgisini ve odalarını getir |

---

## 🧩 Katmanların Görevleri

- **Controller:** API endpointlerini tanımlar, DTO ile veri alışverişi ve validasyonu yönetir.
- **Service:** İş mantığını kapsar, controller ve repository arasında köprü görevi görür.
- **Repository:** Spring Data JPA ile CRUD işlemlerini kolaylaştırır.
- **Entity:** Veritabanı tablolarını ve ilişkileri yansıtan model sınıfları.
- **DTO:** Sadece ihtiyaç duyulan veriyi dış dünyaya açan transfer nesneleri.
- **Exception:** Hataları merkezi olarak yönetir, kullanıcıya anlamlı mesajlar döner.

---

## 🛡️ Validasyon ve Hata Yönetimi

- DTO’larda annotasyonlarla (@NotEmpty, @Email, @Size, vs.) alan doğrulama.
- GlobalExecptionHandler ile tüm validasyon ve diğer hatalar özelleştirilmiş biçimde döner.
- Hatalar, API yanıtında: id, zaman ve detaylı hata mesajlarıyla gösterilir.

---

## ⚙️ Projeyi Çalıştırmak İçin

1. Repoyu klonla:
   ```bash
   git clone https://github.com/faikaktss/One2Many_Spring_Rest.git
   ```
2. `application.properties` dosyasındaki veritabanı bağlantı ayarlarını yapılandır.
3. Projeyi başlat:
   ```bash
   ./mvnw spring-boot:run
   ```
4. API endpointlerini Postman veya benzeri araçlarla test edebilirsin.

---

## 💡 Notlar

- Kodlar açıklamalı ve hem başlangıç hem ileri seviye geliştiriciler için tasarlanmıştır.
- Kurumsal projelerdeki en iyi pratikleri ve gelişmiş ilişkisel veri modellemesini yansıtır.
- Katkı, öneri ve soruların için iletişime geçebilirsin!

---

## 👨‍💻 Geliştirici

Faik Aktaş  
[GitHub Profilim](https://github.com/faikaktss)

---
