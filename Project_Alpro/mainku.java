import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Collections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TebakKata extends JFrame {

    // Objek Random untuk menghasilkan angka acak (digunakan saat mengacak huruf)
    static Random random = new Random();

    // Array 2 dimensi untuk menyimpan pasangan [kata, petunjuk] yang dimuat dari file
    static String[][] daftarKata;

    // Variabel status permainan
    static int skor = 0;
    static int level = 1;
    static boolean bermain = true;
    static String namaPemain = "";
    static String kataTarget = "";
    static String petunjukTarget = "";
    static int kesempatan = 3;

    // Komponen GUI
    static CardLayout cardLayout;
    static JPanel mainPanel;
    static JFrame frame;

    // Komponen Game
    static JLabel lblNama, lblLevel, lblSkor, lblKesempatan;
    static JLabel lblAcakan, lblPanjangHuruf, lblPesan;
    static JTextField txtJawaban;
    static JButton btnTebak, btnHint;

    // Komponen Leaderboard
    static DefaultTableModel tableModel;

    public static void main(String[] args) {
        // Set look and feel ke sistem agar terlihat modern dan native
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            frame = new TebakKata();
            frame.setVisible(true);
        });
    }

    public TebakKata() {
        setTitle("Game Tebak Kata");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createMenuPanel(), "MENU");
        mainPanel.add(createGamePanel(), "GAME");
        mainPanel.add(createLeaderboardPanel(), "LEADERBOARD");

        add(mainPanel);

        // Memuat data kata dari file eksternal saat startup
        daftarKata = muatDaftarKata("daftar_kata.txt");
    }

    /**
     * Method untuk membaca daftar kata dan petunjuk dari file teks eksternal.
     * Mendukung pemisah titik koma (;) maupun koma (,).
     * (Fungsi ini dipertahankan 100% sama seperti kode asli)
     */
    static String[][] muatDaftarKata(String namaFile) {
        File file = new File(namaFile);

        // Fallback: jika program dijalankan dari direktori induk, periksa folder Project_Alpro
        if (!file.exists()) {
            file = new File("Project_Alpro/" + namaFile);
        }

        // Menggunakan ArrayList karena jumlah kata di file bersifat dinamis (tidak diketahui di awal)
        List<String[]> list = new ArrayList<>();

        // Membaca file baris demi baris menggunakan BufferedReader (Try-with-resources untuk auto-close)
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                baris = baris.trim();

                // Lewati baris kosong atau baris komentar yang diawali tanda pagar (#)
                if (baris.isEmpty() || baris.startsWith("#")) {
                    continue;
                }

                // Mendeteksi delimiter: utamakan titik koma (;), jika tidak ada gunakan koma (,)
                String pemisah = baris.contains(";") ? ";" : ",";
                String[] data = baris.split(pemisah, 2);

                // Pastikan format valid: memiliki 2 bagian (kata dan petunjuk)
                if (data.length == 2) {
                    // Simpan kata dalam huruf kapital dan petunjuk tanpa spasi berlebih
                    list.add(new String[]{data[0].trim().toUpperCase(), data[1].trim()});
                }
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }

        // Konversi ArrayList dinamis menjadi array 2 dimensi String[][]
        return list.toArray(new String[0][0]);
    }

    // ================= FITUR BARU: LEADERBOARD =================

    static void simpanLeaderboard(String nama, int skor, int level) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("leaderboard.txt", true))) {
            writer.write(nama + ";" + skor + ";" + level);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Gagal menyimpan leaderboard: " + e.getMessage());
        }
    }

    static List<String[]> muatLeaderboard() {
        List<String[]> list = new ArrayList<>();
        File file = new File("leaderboard.txt");
        if (!file.exists()) {
            file = new File("Project_Alpro/leaderboard.txt");
        }

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String baris;
                while ((baris = reader.readLine()) != null) {
                    baris = baris.trim();
                    if (baris.isEmpty() || baris.startsWith("#")) continue;
                    String[] data = baris.split(";");
                    if (data.length == 3) {
                        list.add(data);
                    }
                }
            } catch (IOException e) {
                System.out.println("Terjadi kesalahan saat membaca leaderboard: " + e.getMessage());
            }
        }

        // Urutkan berdasarkan skor (descending), jika sama urutkan berdasarkan level (descending)
        Collections.sort(list, (a, b) -> {
            int skorA = Integer.parseInt(a[1]);
            int skorB = Integer.parseInt(b[1]);
            if (skorB != skorA) {
                return Integer.compare(skorB, skorA);
            }
            int levelA = Integer.parseInt(a[2]);
            int levelB = Integer.parseInt(b[2]);
            return Integer.compare(levelB, levelA);
        });

        return list;
    }

    // ================= PEMBUATAN PANEL GUI =================

    static JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 247, 250));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel title = new JLabel("GAME TEBAK KATA");
        title.setFont(new Font("Segoe UI", Font.BOLD, 38));
        title.setForeground(new Color(44, 62, 80));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Uji kemampuan kosakata dan logika Anda!");
        subtitle.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        subtitle.setForeground(new Color(127, 140, 141));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setOpaque(false);
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JButton btnMulai = createStyledButton("Mulai Permainan", new Color(46, 204, 113));
        JButton btnLeaderboard = createStyledButton("Leaderboard", new Color(52, 152, 219));
        JButton btnKeluar = createStyledButton("Keluar", new Color(231, 76, 60));

        btnMulai.addActionListener(e -> {
            String nama = JOptionPane.showInputDialog(frame, "Masukkan nama pemain:", "Nama Pemain", JOptionPane.PLAIN_MESSAGE);
            if (nama != null && !nama.trim().isEmpty()) {
                namaPemain = nama.trim();
                skor = 0;
                level = 1;
                bermain = true;

                if (daftarKata == null || daftarKata.length == 0) {
                    JOptionPane.showMessageDialog(frame, "Gagal memuat kata. Pastikan file 'daftar_kata.txt' tersedia dan tidak kosong.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                mulaiLevel();
                cardLayout.show(mainPanel, "GAME");
            }
        });

        btnLeaderboard.addActionListener(e -> {
            updateLeaderboardTable();
            cardLayout.show(mainPanel, "LEADERBOARD");
        });

        btnKeluar.addActionListener(e -> System.exit(0));

        btnPanel.add(btnMulai);
        btnPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        btnPanel.add(btnLeaderboard);
        btnPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        btnPanel.add(btnKeluar);

        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(subtitle);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnPanel);

        return panel;
    }

    static JPanel createGamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBackground(new Color(245, 247, 250));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Top Panel: Stats
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        topPanel.setOpaque(false);
        lblNama = new JLabel("Pemain: -");
        lblLevel = new JLabel("Level: 1");
        lblSkor = new JLabel("Skor: 0");
        lblKesempatan = new JLabel("Kesempatan: 3");

        Font statFont = new Font("Segoe UI", Font.BOLD, 16);
        lblNama.setFont(statFont);
        lblLevel.setFont(statFont);
        lblSkor.setFont(statFont);
        lblKesempatan.setFont(statFont);

        topPanel.add(lblNama);
        topPanel.add(lblLevel);
        topPanel.add(lblSkor);
        topPanel.add(lblKesempatan);

        // Center Panel: Game info
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblAcakan = new JLabel("XXXXXX");
        lblAcakan.setFont(new Font("Monospaced", Font.BOLD, 48));
        lblAcakan.setForeground(new Color(44, 62, 80));
        lblAcakan.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblPanjangHuruf = new JLabel("Jumlah huruf: 0");
        lblPanjangHuruf.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblPanjangHuruf.setForeground(new Color(127, 140, 141));
        lblPanjangHuruf.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblPesan = new JLabel(" ");
        lblPesan.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblPesan.setForeground(new Color(231, 76, 60));
        lblPesan.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(lblAcakan);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(lblPanjangHuruf);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(lblPesan);
        centerPanel.add(Box.createVerticalGlue());

        // Bottom Panel: Input and Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.setOpaque(false);

        txtJawaban = new JTextField(15);
        txtJawaban.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txtJawaban.setHorizontalAlignment(JTextField.CENTER);

        // Fitur: Tekan Enter untuk menebak
        txtJawaban.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    prosesTebakan();
                }
            }
        });

        btnTebak = createStyledButton("Tebak", new Color(46, 204, 113));
        btnTebak.setPreferredSize(new Dimension(120, 45));
        btnTebak.setMaximumSize(new Dimension(120, 45));
        btnTebak.addActionListener(e -> prosesTebakan());

        btnHint = createStyledButton("Hint", new Color(241, 196, 15));
        btnHint.setPreferredSize(new Dimension(120, 45));
        btnHint.setMaximumSize(new Dimension(120, 45));
        btnHint.addActionListener(e -> {
            lblPesan.setText("Petunjuk: " + petunjukTarget);
            lblPesan.setForeground(new Color(52, 152, 219));
            txtJawaban.setText("");
            txtJawaban.requestFocus();
        });

        JButton btnKembaliMenu = createStyledButton("Menu Utama", new Color(149, 165, 166));
        btnKembaliMenu.setPreferredSize(new Dimension(150, 45));
        btnKembaliMenu.setMaximumSize(new Dimension(150, 45));
        btnKembaliMenu.addActionListener(e -> {
            bermain = false;
            cardLayout.show(mainPanel, "MENU");
        });

        bottomPanel.add(txtJawaban);
        bottomPanel.add(btnTebak);
        bottomPanel.add(btnHint);
        bottomPanel.add(btnKembaliMenu);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    static JPanel createLeaderboardPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(245, 247, 250));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("LEADERBOARD", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(44, 62, 80));
        panel.add(title, BorderLayout.NORTH);

        String[] columns = {"Peringkat", "Nama Pemain", "Skor", "Level Tercapai"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        table.setRowHeight(35);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        table.getTableHeader().setBackground(new Color(52, 152, 219));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        JButton btnKembali = createStyledButton("Kembali ke Menu", new Color(149, 165, 166));
        btnKembali.setPreferredSize(new Dimension(200, 45));
        btnKembali.setMaximumSize(new Dimension(200, 45));
        btnKembali.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        bottomPanel.add(btnKembali);

        panel.add(bottomPanel, BorderLayout.SOUTH);
        return panel;
    }

    static void updateLeaderboardTable() {
        tableModel.setRowCount(0);
        List<String[]> data = muatLeaderboard();
        int rank = 1;
        for (String[] row : data) {
            if (rank > 10) break; // Tampilkan Top 10 saja
            tableModel.addRow(new Object[]{rank++, row[0], row[1], row[2]});
        }
        if (data.isEmpty()) {
            tableModel.addRow(new Object[]{"-", "Belum ada data", "-", "-"});
        }
    }

    // ================= LOGIKA PERMAINAN (DIPERTAHANKAN) =================

    static void mulaiLevel() {
        if (level > daftarKata.length) {
            selesaiPermainan(true);
            return;
        }

        kataTarget = daftarKata[level - 1][0];
        petunjukTarget = daftarKata[level - 1][1];
        
        // Menghitung jumlah kesempatan: semakin tinggi level semakin sedikit, minimal 3 kali
        kesempatan = Math.max(3, 8 - level);

        lblNama.setText("Pemain: " + namaPemain);
        lblLevel.setText("Level: " + level);
        lblSkor.setText("Skor: " + skor);
        lblKesempatan.setText("Kesempatan: " + kesempatan);
        lblPesan.setText(" ");
        txtJawaban.setText("");
        txtJawaban.requestFocus();

        // Mengonversi kata menjadi array karakter untuk diacak
        char[] huruf = kataTarget.toCharArray();

        // Algoritma Fisher-Yates Shuffle untuk mengacak posisi karakter
        for (int i = huruf.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Memilih indeks acak antara 0 hingga i
            // Menukar huruf ke-i dengan huruf ke-j
            char temp = huruf[i];
            huruf[i] = huruf[j];
            huruf[j] = temp;
        }

        // Mengubah kembali array karakter yang telah teracak menjadi String
        String acakan = new String(huruf);
        
        // Tambahan UX: Pastikan hasil acakan tidak sama persis dengan kata asli (jika panjang > 1)
        while (acakan.equals(kataTarget) && kataTarget.length() > 1) {
            for (int i = huruf.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                char temp = huruf[i];
                huruf[i] = huruf[j];
                huruf[j] = temp;
            }
            acakan = new String(huruf);
        }

        lblAcakan.setText(acakan);
        lblPanjangHuruf.setText("Jumlah huruf: " + kataTarget.length());
    }

    static void prosesTebakan() {
        if (!bermain) return;

        String jawaban = txtJawaban.getText().trim().toUpperCase();
        if (jawaban.isEmpty()) return;

        // Fitur bantuan: jika pemain mengetik "HINT", tampilkan petunjuk tanpa mengurangi kesempatan
        if (jawaban.equals("HINT")) {
            lblPesan.setText("Petunjuk: " + petunjukTarget);
            lblPesan.setForeground(new Color(52, 152, 219));
            txtJawaban.setText("");
            txtJawaban.requestFocus();
            return;
        }

        // Validasi tebakan dengan kata target
        if (jawaban.equals(kataTarget)) {
            lblPesan.setText("BENAR! Kamu berhasil!");
            lblPesan.setForeground(new Color(46, 204, 113));
            
            // Skor bertambah proporsional dengan tingkatan level
            skor += level * 100;
            lblSkor.setText("Skor: " + skor);

            // Delay halus sebelum naik level agar UX lebih baik
            Timer timer = new Timer(1000, e -> {
                level++;
                mulaiLevel();
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            kesempatan--; // Kurangi kesempatan jika tebakan salah
            lblKesempatan.setText("Kesempatan: " + kesempatan);
            lblPesan.setText("SALAH! Coba lagi. Sisa kesempatan: " + kesempatan);
            lblPesan.setForeground(new Color(231, 76, 60));
            txtJawaban.setText("");
            txtJawaban.requestFocus();

            if (kesempatan <= 0) {
                bermain = false;
                Timer timer = new Timer(1500, e -> selesaiPermainan(false));
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    static void selesaiPermainan(boolean menang) {
        // Simpan hasil ke leaderboard
        simpanLeaderboard(namaPemain, skor, level);

        String pesan;
        if (menang) {
            pesan = "SELAMAT! KAMU MENYELESAIKAN SEMUA LEVEL!\nTotal Skor: " + skor;
        } else {
            pesan = "GAME OVER!\nJawaban yang benar: " + kataTarget + "\nTotal Skor: " + skor;
        }

        JOptionPane.showMessageDialog(frame, pesan, "Hasil Akhir", JOptionPane.INFORMATION_MESSAGE);
        cardLayout.show(mainPanel, "MENU");
    }

    // ================= UTILITAS GUI =================

    static JButton createStyledButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setForeground(Color.WHITE);
        btn.setBackground(bgColor);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(250, 50));
        btn.setMaximumSize(new Dimension(300, 50));
        return btn;
    }
}