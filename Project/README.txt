Kelompok 1 :
1. Nabela Azzahra Putri / V3425015
2. Kaishan Arya Setiko / V3425033
3. Zidnii Aghniya Rajwa / V3425038
4. Leonard Jonathan Saputra / V3425069

IDE IMPLEMENTASI

Tema : Toko serba ada / minimarket sederhana

Deksripsi singkat : 
Program pembelanjaan produk di kasir dengan menginput kode barang, total harga akan dihitung dan output akan dalam bentuk nota pembelanjaan. Program juga diatur agar dapat mengatur(melihat dan menambah) stock barang.

Contoh fitur :
Menambah dan mengecek persediaan barang, 
Belanja (menjumlahkan harga barang sebelum klik selesai, memberikan total harga dan barang)
Tampilkan nota pembelanjaan.

Ekstra Fitur: 
Diskon tanggal ganjil/genap
Potongan menggunakan pembayaran tertentu (Tunai, qris, dll)
Hitung kembalian (Tunai)

Output Program 
== LOGIN ==
Nama		: 
Tanggal	:

== MENU HOME ==
Pembelian
Daftar Barang
Keluar




== PEMBELIAN ==
Kode Barang	:
Jumlah	:
(Rancangan, Kode Barang = 999 = Keluar)

== PEMBAYARAN ==
QRIS
Tunai

== PEMBAYARAN (TUNAI) ==
Total Belanja	  :
Diskon	  :
Total		  :
Uang Masuk	  :
Uang Kembali :

== STRUK ==
Tanggal
Brg | Harga Satuan | Jml | SubTotal
Brg | Harga Satuan | Jml | SubTotal
Brg | Harga Satuan | Jml | SubTotal
Brg | Harga Satuan | Jml | SubTotal
…
Total Belanja		:
Uang Masuk		:
Uang Kembali	:

== DAFTAR BARANG ==
Kode | Nama | Harga | Stock
Kode | Nama | Harga | Stock
Kode | Nama | Harga | Stock
Kode | Nama | Harga | Stock
…
Tambah Stock
Tambah Barang
Selesai

== TAMBAH STOCK ==
Kode Barang
Jumlah
== TAMBAH BARANG ==
Kode Barang
Nama Barang
Jumlah

== REKAPITULASI HARIAN ==
Pendapatan “Tanggal” : 
 

FLOW
LOGIN:
Input:
Nama
Tanggal
MENU HOME:
*perulangan
Input:
Pembelian
Daftar Barang
Keluar
If PEMBELIAN: 
*perulangan
Input:
Kode Barang
Jumlah
Selesai
			Pembayaran:
			a. QRIS
			b. Tunai
			
If QRIS:
			Diskon = 1000
			If Tunai:
			Input Jml Uang -> Kembalian = Jml Uang - Total Belanja
			
			Tanggal Ganjil -> Diskon = Diskon + Total Belanja * 5%
			Tanggal Genap -> Diskon = Diskon + Total Belanja * 6% 
		Diskon = Diskon
Total = Total Belanja - Diskon
			
	If DAFTAR BARANG:
		Output: Kode | Nama | Harga | Stock
		Input:
Tambah Stock
Tambah Barang
Selesai
		If Tambah Stock:
			Input:
Kode Barang
Jumlah
		If Tambah Barang:
			Input:
Kode Barang
Nama
Jumlah
		If Selesai:
		Kembali MENU HOME.

	If KELUAR:
	Pendapatan 1 Hari = Total Final Banget.Banget.Banget
Kembali LOGIN
	

