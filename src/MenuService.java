import java.util.*;

public class MenuService {
    static Scanner scanner = new Scanner(System.in);

    static List<Saham> daftarSaham = new ArrayList<>();
    static List<SuratBerhargaNegara> daftarSBN = new ArrayList<>();
    static List<Admin> adminList = new ArrayList<>();
    static List<Customer> customerList = new ArrayList<>();
    static User currentUser = null;

    public static void run() {
        seedData();

        while (true) {
            ClearScreen.clear();          
            System.out.println("+======================+");
            System.out.println("|         MENU         |");
            System.out.println("+======================+");
            System.out.println("| 1. Login             |");
            System.out.println("| 2. Exit              |");
            System.out.println("+======================+");
            System.out.print("Masukkan pilihan: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();
            ClearScreen.clear();
        
            switch (pilih) {
                case 1 -> login();
                case 2 -> {
                    System.out.println("Terima kasih!");
                    System.exit(0);
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
            }

    static void seedData() {
        adminList.add(new Admin("admin", "admin123"));
        customerList.add(new Customer("cust", "cust123"));
    }

    static void login() {
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        for (Admin admin : adminList) {
            if (admin.username.equals(username) && admin.password.equals(password)) {
                currentUser = admin;
                menuAdmin();
                return;
            }
        }

        for (Customer customer : customerList) {
            if (customer.username.equals(username) && customer.password.equals(password)) {
                currentUser = customer;
                menuCustomer((Customer) currentUser);
                return;
            }
        }

        System.out.println("Login gagal. Username atau password salah.");
    }

    static void menuAdmin() {
        while (true) {
            ClearScreen.clear();
            System.out.println("+=============================+");
            System.out.println("|         MENU ADMIN          |");
            System.out.println("+=============================+");
            System.out.println("| 1 | Kelola Saham            |");
            System.out.println("| 2 | Kelola SBN              |");
            System.out.println("| 3 | Logout                  |");
            System.out.println("+=============================+");
            System.out.print("Pilih menu (1-3): ");
            
            int pilih = scanner.nextInt();
            scanner.nextLine();
            ClearScreen.clear();
    
            switch (pilih) {
                case 1 -> menuSahamAdmin();
                case 2 -> menuSBNAdmin();
                case 3 -> {
                    currentUser = null;
                    return;
                }
                default -> {
                    System.out.println("Pilihan tidak valid, tekan Enter untuk lanjut...");
                    scanner.nextLine();
                }
            }
        }
    }
    
    static void menuSahamAdmin() {
        while (true) {
            ClearScreen.clear();
            System.out.println("+=============================+");
            System.out.println("|         SAHAM ADMIN         |");
            System.out.println("+=============================+");
            System.out.println("| 1 | Tambah Saham            |");
            System.out.println("| 2 | Ubah Harga Saham        |");
            System.out.println("| 3 | Kembali                 |");
            System.out.println("+=============================+");
            System.out.print("Pilih menu (1-3): ");
            
            int pilih = scanner.nextInt();
            scanner.nextLine();
    
            switch (pilih) {
                case 1 -> {
                    ClearScreen.clear();
                    System.out.println("+=============================+");
                    System.out.println("|         TAMBAH SAHAM        |");
                    System.out.println("+=============================+");
                    System.out.print("Kode Saham: ");
                    String kode = scanner.nextLine();
                    System.out.print("Nama Perusahaan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Harga Saham: ");
                    double harga = scanner.nextDouble();
                    daftarSaham.add(new Saham(kode, nama, harga));
                    System.out.println("\nSaham berhasil ditambahkan!");
                    System.out.println("Tekan Enter untuk kembali...");
                    scanner.nextLine();
                }
                case 2 -> {
                    ClearScreen.clear();
                    System.out.println("+=============================+");
                    System.out.println("|        UBAH HARGA SAHAM     |");
                    System.out.println("+=============================+");
                    if (daftarSaham.isEmpty()) {
                        System.out.println("Belum ada saham yang tersedia.");
                    } else {
                        for (int i = 0; i < daftarSaham.size(); i++) {
                            Saham s = daftarSaham.get(i);
                            System.out.printf("| %d | %s - %s (Rp %.2f)\n", i+1, s.kode, s.namaPerusahaan, s.harga);
                        }
                        System.out.println("+-----------------------------+");
                        System.out.print("Pilih saham untuk ubah harga: ");
                        int idx = scanner.nextInt() - 1;
                        System.out.print("Masukkan harga baru: ");
                        double hargaBaru = scanner.nextDouble();
                        daftarSaham.get(idx).harga = hargaBaru;
                        System.out.println("\nHarga saham berhasil diubah!");
                    }
                    System.out.println("Tekan Enter untuk kembali...");
                    scanner.nextLine();
                    scanner.nextLine();
                }
                case 3 -> {
                    return;
                }
                default -> {
                    System.out.println("Pilihan tidak valid, tekan Enter untuk lanjut...");
                    scanner.nextLine();
                }
            }
        }
    }
    
    static void menuSBNAdmin() {
        while (true) {
            ClearScreen.clear();
            System.out.println("+-----------------------------+");
            System.out.println("|          SBN ADMIN          |");
            System.out.println("+-----------------------------+");
            System.out.println("| 1. Tambah SBN               |");
            System.out.println("| 2. Kembali                  |");
            System.out.println("+-----------------------------+");
            System.out.print("Pilih Menu [1-2]: ");
            
            int pilih = scanner.nextInt();
            scanner.nextLine(); 
            ClearScreen.clear();
    
            switch (pilih) {
                case 1 -> {
                    System.out.println("+-----------------------------+");
                    System.out.println("|         TAMBAH SBN          |");
                    System.out.println("+-----------------------------+");
                    System.out.print("Nama SBN             : ");
                    String nama = scanner.nextLine();
                    System.out.print("Bunga (% per tahun)  : ");
                    double bunga = scanner.nextDouble();
                    System.out.print("Jangka Waktu (bulan) : ");
                    int jangkaWaktu = scanner.nextInt();
                    scanner.nextLine(); // buang newline
                    System.out.print("Tanggal Jatuh Tempo  : ");
                    String tjt = scanner.nextLine();
                    System.out.print("Kuota Nasional       : ");
                    double kuota = scanner.nextDouble();
    
                    daftarSBN.add(new SuratBerhargaNegara(nama, bunga, jangkaWaktu, tjt, kuota));
                    System.out.println("\n[SUCCESS] SBN berhasil ditambahkan!");
                    System.out.println("Tekan ENTER untuk kembali...");
                    scanner.nextLine();
                }
                case 2 -> {
                    return;
                }
                default -> {
                    System.out.println("\n[ERROR] Pilihan tidak valid!");
                    System.out.println("Tekan ENTER untuk lanjut...");
                    scanner.nextLine();
                }
            }
        }
    }
    
    static void menuCustomer(Customer customer) {
        while (true) {
            ClearScreen.clear();
            System.out.println("+--------------------------------+");
            System.out.println("|         MENU CUSTOMER          |");
            System.out.println("+--------------------------------+");
            System.out.println("| 1. Beli Saham                  |");
            System.out.println("| 2. Jual Saham                  |");
            System.out.println("| 3. Beli SBN                    |");
            System.out.println("| 4. Simulasi SBN                |");
            System.out.println("| 5. Lihat Portofolio            |");
            System.out.println("| 6. Logout                      |");
            System.out.println("+--------------------------------+");
            System.out.print("Pilih Menu [1-6]: ");
            
            int pilih = scanner.nextInt();
            scanner.nextLine(); 
            ClearScreen.clear();
    
            switch (pilih) {
                case 1 -> beliSaham(customer);
                case 2 -> jualSaham(customer);
                case 3 -> beliSBN(customer);
                case 4 -> simulasiSBN(customer);
                case 5 -> lihatPortofolio(customer);
                case 6 -> {
                    currentUser = null;
                    return;
                }
                default -> {
                    System.out.println("\n[ERROR] Pilihan tidak valid!");
                    System.out.println("Tekan ENTER untuk lanjut...");
                    scanner.nextLine();
                }
            }
        }
    }
    
    static void beliSaham(Customer customer) {
        System.out.println("\nDaftar Saham:");
        for (int i = 0; i < daftarSaham.size(); i++) {
            Saham s = daftarSaham.get(i);
            System.out.println((i+1) + ". " + s.kode + " - " + s.namaPerusahaan + " (Rp " + s.harga + ")");
        }
        System.out.print("Pilih saham: ");
        int idx = scanner.nextInt() - 1;
        System.out.print("Jumlah lembar yang dibeli: ");
        int jumlah = scanner.nextInt();
        Saham sahamDipilih = daftarSaham.get(idx);

        customer.sahamDimiliki.add(new PortfolioItemSaham(sahamDipilih, jumlah, jumlah * sahamDipilih.harga));
        System.out.println("Pembelian saham berhasil.");
    }

    static void jualSaham(Customer customer) {
        if (customer.sahamDimiliki.isEmpty()) {
            System.out.println("Tidak ada saham yang dimiliki.");
            return;
        }
        System.out.println("\nSaham Dimiliki:");
        for (int i = 0; i < customer.sahamDimiliki.size(); i++) {
            PortfolioItemSaham p = customer.sahamDimiliki.get(i);
            System.out.println((i+1) + ". " + p.saham.kode + " - " + p.jumlahLembar + " lembar");
        }
        System.out.print("Pilih saham untuk dijual: ");
        int idx = scanner.nextInt() - 1;
        PortfolioItemSaham p = customer.sahamDimiliki.get(idx);

        System.out.print("Jumlah lembar yang dijual: ");
        int jumlah = scanner.nextInt();
        if (jumlah > p.jumlahLembar) {
            System.out.println("Gagal. Jumlah lembar melebihi yang dimiliki.");
        } else {
            p.jumlahLembar -= jumlah;
            System.out.println("Saham berhasil dijual.");
            if (p.jumlahLembar == 0) {
                customer.sahamDimiliki.remove(idx);
            }
        }
    }

    static void beliSBN(Customer customer) {
        System.out.println("\nDaftar SBN:");
        for (int i = 0; i < daftarSBN.size(); i++) {
            SuratBerhargaNegara s = daftarSBN.get(i);
            System.out.println((i+1) + ". " + s.nama + " - Kuota: Rp " + s.kuotaNasional);
        }
        System.out.print("Pilih SBN: ");
        int idx = scanner.nextInt() - 1;
        System.out.print("Nominal pembelian: ");
        double nominal = scanner.nextDouble();

        SuratBerhargaNegara sbnDipilih = daftarSBN.get(idx);
        if (nominal > sbnDipilih.kuotaNasional) {
            System.out.println("Gagal. Kuota tidak mencukupi.");
        } else {
            customer.sbnDimiliki.add(new PortfolioItemSBN(sbnDipilih, nominal));
            sbnDipilih.kuotaNasional -= nominal;
            System.out.println("Pembelian SBN berhasil.");
        }
    }

    static void simulasiSBN(Customer customer) {
        System.out.println("\nSimulasi Kupon SBN:");
        for (PortfolioItemSBN p : customer.sbnDimiliki) {
            double bungaPerBulan = (p.sbn.bunga / 100) / 12 * 0.9 * p.nominalInvestasi;
            System.out.println(p.sbn.nama + " - Bunga per bulan: Rp " + bungaPerBulan);
        }
    }

    static void lihatPortofolio(Customer customer) {
        ClearScreen.clear();
        System.out.println("+--------------------------------------+");
        System.out.println("|            PORTOFOLIO                |");
        System.out.println("+--------------------------------------+");
    
        System.out.println("|              SAHAM                   |");
        if (customer.sahamDimiliki.isEmpty()) {
            System.out.println("| (Belum memiliki saham)               |");
        } else {
            for (PortfolioItemSaham p : customer.sahamDimiliki) {
                double nilaiPasar = p.jumlahLembar * p.saham.harga;
                System.out.println("| " + p.saham.kode + " - " + p.jumlahLembar + " lembar");
                System.out.println("|    Total Beli : Rp " + String.format("%,.2f", p.totalNominalPembelian));
                System.out.println("|    Nilai Pasar: Rp " + String.format("%,.2f", nilaiPasar));
            }
        }
        System.out.println("+--------------------------------------+");
    
        System.out.println("|               SBN                    |");
        if (customer.sbnDimiliki.isEmpty()) {
            System.out.println("| (Belum memiliki SBN)                 |");
        } else {
            for (PortfolioItemSBN p : customer.sbnDimiliki) {
                double bungaPerBulan = (p.sbn.bunga / 100) / 12 * 0.9 * p.nominalInvestasi;
                System.out.println("| " + p.sbn.nama);
                System.out.println("|    Nominal Investasi: Rp " + String.format("%,.2f", p.nominalInvestasi));
                System.out.println("|    Bunga / Bulan    : Rp " + String.format("%,.2f", bungaPerBulan));
            }
        }
        System.out.println("+--------------------------------------+");
    
        System.out.println("\nTekan ENTER untuk kembali ke menu...");
        scanner.nextLine();
    }
    }