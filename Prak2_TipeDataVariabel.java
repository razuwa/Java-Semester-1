public class Prak2_TipeDataVariabel {
    public static void main(String[] args) {
        String nama;
        nama = "Muhammad Ibnu";
        int umur, tahunlahir;
        tahunlahir = 2000;
        umur = 2025 - tahunlahir;
        double ipk = 3.99;
        char kelas = 'c';
        boolean mahasiswa = true;
        System.out.println("Nama saya " + nama);
        System.out.println("Tahun lahir " + tahunlahir);
        System.out.println("Umur saya " + umur);
        System.out.println("Status keaktifan " + mahasiswa);
        System.out.println("Dua tahun lagi umur saya " + (umur+2));
        int duabelas_th_lalu;
        duabelas_th_lalu = umur - 12;
        System.out.println("Dua belas tahun yang lalu umur saya " + (duabelas_th_lalu));

    }
}
