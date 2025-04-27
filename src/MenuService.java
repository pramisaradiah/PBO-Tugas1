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
            System.out.println("\n--- MENU AWAL ---");
            System.out.println("1. Login");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> login();
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void seedData() {
        adminList.add(new Admin("admin", "admin123"));
        customerList.add(new Customer("cust", "cust123"));
    }

    static void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
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
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1. Saham");
            System.out.println("2. SBN");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> menuSahamAdmin();
                case 2 -> menuSBNAdmin();
                case 3 -> {
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void menuSahamAdmin() {
        while (true) {
            System.out.println("\n--- SAHAM ADMIN ---");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Kembali");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> {
                    System.out.print("Kode Saham: ");
                    String kode = scanner.nextLine();
                    System.out.print("Nama Perusahaan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Harga Saham: ");
                    double harga = scanner.nextDouble();
                    daftarSaham.add(new Saham(kode, nama, harga));
                    System.out.println("Saham berhasil ditambahkan.");
                }
                case 2 -> {
                    System.out.println("Daftar Saham:");
                    for (int i = 0; i < daftarSaham.size(); i++) {
                        System.out.println((i+1) + ". " + daftarSaham.get(i).kode + " - " + daftarSaham.get(i).namaPerusahaan + " (Rp " + daftarSaham.get(i).harga + ")");
                    }
                    System.out.print("Pilih saham untuk ubah harga: ");
                    int idx = scanner.nextInt() - 1;
                    System.out.print("Masukkan harga baru: ");
                    double hargaBaru = scanner.nextDouble();
                    daftarSaham.get(idx).harga = hargaBaru;
                    System.out.println("Harga saham berhasil diubah.");
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void menuSBNAdmin() {
        while (true) {
            System.out.println("\n--- SBN ADMIN ---");
            System.out.println("1. Tambah SBN");
            System.out.println("2. Kembali");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> {
                    System.out.print("Nama SBN: ");
                    String nama = scanner.nextLine();
                    System.out.print("Bunga (% per tahun): ");
                    double bunga = scanner.nextDouble();
                    System.out.print("Jangka Waktu (bulan): ");
                    int jangkaWaktu = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tanggal Jatuh Tempo: ");
                    String tjt = scanner.nextLine();
                    System.out.print("Kuota Nasional: ");
                    double kuota = scanner.nextDouble();
                    daftarSBN.add(new SuratBerhargaNegara(nama, bunga, jangkaWaktu, tjt, kuota));
                    System.out.println("SBN berhasil ditambahkan.");
                }
                case 2 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void menuCustomer(Customer customer) {
        while (true) {
            System.out.println("\n--- MENU CUSTOMER ---");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Logout");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

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
                default -> System.out.println("Pilihan tidak valid.");
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
        System.out.println("\n--- PORTOFOLIO ---");
        System.out.println("Saham:");
        for (PortfolioItemSaham p : customer.sahamDimiliki) {
            double nilaiPasar = p.jumlahLembar * p.saham.harga;
            System.out.println(p.saham.kode + " - " + p.jumlahLembar + " lembar, Total Beli: Rp " + p.totalNominalPembelian + ", Nilai Pasar: Rp " + nilaiPasar);
        }
        System.out.println("SBN:");
        for (PortfolioItemSBN p : customer.sbnDimiliki) {
            double bungaPerBulan = (p.sbn.bunga / 100) / 12 * 0.9 * p.nominalInvestasi;
            System.out.println(p.sbn.nama + " - Nominal: Rp " + p.nominalInvestasi + ", Bunga/Bulan: Rp " + bungaPerBulan);
        }
    }
}
