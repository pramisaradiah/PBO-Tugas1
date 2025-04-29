# **Program Investasi Saham dan Surat Berharga Negara (SBN)**

Program ini adalah aplikasi berbasis Java yang memungkinkan pengguna melakukan investasi di pasar saham dan Surat Berharga Negara (SBN). Terdapat dua jenis pengguna dalam program ini, yaitu Admin dan Customer. Admin memiliki hak untuk mengelola produk investasi, sementara Customer dapat melakukan pembelian, penjualan, dan melihat portofolio investasi mereka.

## **Fitur Program:**

1. **Login**: 
   Pengguna harus login dengan akun yang telah di-hardcode pada program. Jika login berhasil, pengguna akan dibawa ke menu investasi saham atau SBN. Jika gagal, akan ditampilkan pesan kegagalan login.

2. **Admin**: 
   - Admin dapat menambah, mengubah harga saham, dan menambahkan produk SBN.
   - Admin memiliki akses ke menu "Saham" dan "SBN" untuk melakukan tindakan ini.

3. **Customer**: 
   - Customer dapat melakukan pembelian dan penjualan saham.
   - Customer dapat membeli SBN.
   - Customer dapat melihat portofolio yang berisi daftar saham dan SBN yang dimiliki serta simulasi bunga bulanan SBN yang diterima.

4. **Proses Investasi**:
   - Saat customer membeli saham, program akan menampilkan daftar saham yang tersedia. Customer memilih saham dan memasukkan jumlah lembar saham yang ingin dibeli.
   - Customer dapat menjual saham yang dimilikinya dengan memilih saham dan jumlah lembar yang ingin dijual. Jika melebihi jumlah saham yang dimiliki, program akan menampilkan pesan gagal.
   - Customer dapat membeli SBN dengan memilih SBN yang tersedia dan memasukkan nominal pembelian.

5. **Portofolio**: 
   Portofolio customer menampilkan daftar saham yang dimiliki beserta jumlah dan total nominal pembelian. Selain itu, portofolio juga menampilkan total nilai pasar saham dan bunga SBN yang diterima setiap bulan.

## **Identitas Kelompok**
1. Ni Made Indri Cahyani (2405551104)
2. Ni Putu Diah Pramisara Putri (2405551135)

## **UML Program Investasi Saham**
![UML-saham](https://github.com/user-attachments/assets/30f61ccc-8b8d-48ac-b3ed-971a8eb016d9)

## **Dokumentasi Program**
Dibawah ini merupakan dokumentasi program investasi saham dan surat berharga negara (SBN) beserta hasil screenshoot. Beberapa penjelasan bagaimana kode berjalan akan dijelaskan dibawah.

### **Login Admin dan Customer**
![WhatsApp Image 2025-04-29 at 23 08 24_3238c2d6](https://github.com/user-attachments/assets/47418526-70d5-479a-a8d6-0bf3400ca76f)
![WhatsApp Image 2025-04-29 at 23 22 43_f55e218f](https://github.com/user-attachments/assets/8b13deb0-12c7-4604-8c3c-d7060ab63f64)
![WhatsApp Image 2025-04-29 at 23 27 46_3e521d73](https://github.com/user-attachments/assets/c0f2bb03-d6bd-4914-92f1-1031b52a3003)
Pertama akan ditampilkan menu yang berisi login dan exit. User memilih login jika akan melakukan login. Kemudian user diminta untuk memasukkan username dan password. Jika benar, maka program akan menampilkan menu administrator atau menu customer

### **Menu Administrator**
![WhatsApp Image 2025-04-29 at 23 22 43_af1b95ed](https://github.com/user-attachments/assets/cfd52fda-fc31-4524-b272-1615c2c485e5)
Setelah melakukan login sebagai administrator, maka user akan ditampilkan menu administrator seperti gambar di atas. Admin bisa memilih opsi di atas dengan menginput angka.

### **Menu Customer**
![WhatsApp Image 2025-04-29 at 23 29 52_5984e4e4](https://github.com/user-attachments/assets/7e563bf1-cba4-426f-b042-536dc4120680)
Setelah melakukan login sebagai customer, maka user akan ditampilkan menu customer seperti gambar di atas. Customer bisa memilih opsi di atas dengan menginput angka.

### **Tambah Saham**
![WhatsApp Image 2025-04-29 at 23 22 43_9891660a](https://github.com/user-attachments/assets/0b8fd207-1ea2-452b-a613-91141537c5cc)
![WhatsApp Image 2025-04-29 at 23 22 43_f071bb15](https://github.com/user-attachments/assets/cc853600-a017-462f-a46a-0bd663cc56ec)
![WhatsApp Image 2025-04-30 at 01 13 54_f106fa08](https://github.com/user-attachments/assets/b062120b-5d99-494d-979e-2c3bd04b047f)
Jika admin memilih kelola saham, admin akan diberikan opsi seperti gambar di atas. Jika memilih tambah saham, admin diminta untuk memasukkan kode saham, nama perusahaan, dan juga harga saham per lembar. Jika berhasil, akan ditampilkan output saham berhasil ditambahkan.

### **Ubah Harga Saham**
![WhatsApp Image 2025-04-30 at 01 16 12_edb3e8dd](https://github.com/user-attachments/assets/57e6aee9-5aa2-4032-9e5a-9a655cff1e69)
![WhatsApp Image 2025-04-30 at 01 17 04_0e9e582a](https://github.com/user-attachments/assets/183696c1-a58a-40a4-86b6-6ae72aa1c760)
Jika admin memilih ubah harga saham, admin diminta untuk memilih saham yang akan diubah hargany dan memasukkan harga baru. Jika berhasil, program menampilkan harga saham berhasil diubah.

### **Tambah SBN**
![WhatsApp Image 2025-04-30 at 01 47 06_e4790159](https://github.com/user-attachments/assets/1d11adb7-5ced-4914-a798-5bf620776159)
Selain kelola saham, admin juga bisa mengelola SBN. Jika memilih kelola SBN, admin diminta untuk memasukkan nama SBN, bunga, jangka waktu, tanggal jatuh tempo, serta kuota nasional.

### **Beli Saham**
![WhatsApp Image 2025-04-30 at 01 26 29_8a1736a6](https://github.com/user-attachments/assets/1fc1baa5-88ff-4383-bfcd-b4719379895f)
Jika customer memilih beli saham, customer akan diminta untuk memilih daftar saham, kemudian memasukkan jumlah lembar yang ingin dibeli dari saham tersebut.

### **Jual Saham**
![WhatsApp Image 2025-04-30 at 01 33 26_523f883f](https://github.com/user-attachments/assets/b13b0deb-2915-482e-a90e-adccd9864443)
Jika customer memilih jual saham, maka customer diminta untuk memilih saham yang dimiliki untuk dijual, kemudian memasukkan jumlah lembar yang ingin dijual.

### **Beli SBN**
![WhatsApp Image 2025-04-30 at 01 49 23_f43bbe34](https://github.com/user-attachments/assets/2c497964-fe9e-48f9-9c69-8da1c54237b9)
Jika customer memilih beli SBN, customer akan diminta memilih daftar SBN terlebih dahulu, kemudian memasukkan nominal pembelian.

### **Simulasi SBN**
![WhatsApp Image 2025-04-30 at 05 34 23_d3916092](https://github.com/user-attachments/assets/712bec1f-9c20-4f53-a465-9d8538226457)
Jika customer memilih simulasi SBN, program akan menampilkan hasil perhitungan bunga per bulan bagi setiap kupon SBN yang tersedia.

### **Lihat Portofolio**
![WhatsApp Image 2025-04-30 at 01 50 17_22519381](https://github.com/user-attachments/assets/98f30abb-7db9-4e60-95aa-f93f2623ace3)
Jika customer memilih portfolio, maka program akan metampilkan daftar saham dan daftar SBN yang dimiliki oleh customer
