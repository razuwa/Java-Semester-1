Kelompok 1 :  
1\. Nabela Azzahra Putri / V3425015  
2\. Kaishan Arya Setiko / V3425033  
3\. Zidnii Aghniya Rajwa / V3425038  
4\. Leonard Jonathan Saputra / V3425069

IDE IMPLEMENTASI

Tema : Toko serba ada / minimarket sederhana

Deksripsi singkat :   
Program pembelanjaan produk di kasur dengan menginput kode barang, total harga akan dihitung dan output akan dalam bentuk nota pembelanjaan. Program juga diatur agar dapat mengatur(melihat dan menambah) stock barang.

Contoh fitur :

- Menambah dan mengecek persediaan barang,   
- Belanja (menjumlahkan harga barang sebelum klik selesai, memberikan total harga dan barang)  
- Tampilkan nota pembelanjaan.

Ekstra Fitur: 

- Diskon tanggal ganjil/genap  
- Potongan menggunakan pembayaran tertentu (Tunai, qris, dll)  
- Hitung kembalian (Tunai)

Output Program   
\== LOGIN \==  
Nama		:   
Tanggal	:

\== MENU HOME \==

1. Pembelian  
2. Daftar Barang  
3. Keluar

\== PEMBELIAN \==  
Kode Barang	:  
Jumlah	:  
(Rancangan, Kode Barang \= 999 \= Keluar)

\== PEMBAYARAN \==

1. QRIS  
2. Tunai

\== PEMBAYARAN (TUNAI) \==  
Total Belanja	  :  
Diskon	  :  
Total		  :  
Uang Masuk	  :  
Uang Kembali :

\== STRUK \==  
Tanggal  
Brg | Harga Satuan | Jml | SubTotal  
Brg | Harga Satuan | Jml | SubTotal  
Brg | Harga Satuan | Jml | SubTotal  
Brg | Harga Satuan | Jml | SubTotal  
…  
Total Belanja		:  
Uang Masuk		:  
Uang Kembali	:

\== DAFTAR BARANG \==  
Kode | Nama | Harga | Stock  
Kode | Nama | Harga | Stock  
Kode | Nama | Harga | Stock  
Kode | Nama | Harga | Stock  
…

1. Tambah Stock  
2. Tambah Barang  
3. Selesai

\== TAMBAH STOCK \==

1. Kode Barang  
2. Jumlah

\== TAMBAH BARANG \==

1. Kode Barang  
2. Nama Barang  
3. Jumlah

\== REKAPITULASI HARIAN \==  
Pendapatan “Tanggal” :   
 

FLOW  
LOGIN:  
Input:

1. Nama  
2. Tanggal

MENU HOME:  
\*perulangan  
Input:

1. Pembelian  
2. Daftar Barang  
3. Keluar  
   If PEMBELIAN:   
   \*perulangan  
1. Input:  
1. Kode Barang  
2. Jumlah  
2. Selesai

			Pembayaran:  
			a. QRIS  
			b. Tunai  
			  
If QRIS:  
			Diskon \= 1000  
			If Tunai:  
			Input Jml Uang \-\> Kembalian \= Jml Uang \- Total Belanja  
			  
			Tanggal Ganjil \-\> Diskon \= Diskon \+ Total Belanja \* 5%  
			Tanggal Genap \-\> Diskon \= Diskon \+ Total Belanja \* 6%   
		Diskon \= Diskon  
Total \= Total Belanja \- Diskon  
			  
	If DAFTAR BARANG:  
		Output: Kode | Nama | Harga | Stock  
		Input:

1. Tambah Stock  
2. Tambah Barang  
3. Selesai

		If Tambah Stock:  
			Input:

1. Kode Barang  
2. Jumlah

		If Tambah Barang:  
			Input:

1. Kode Barang  
2. Nama  
3. Jumlah

		If Selesai:  
		Kembali MENU HOME.

	If KELUAR:  
	Pendapatan 1 Hari \= Total Final Banget.Banget.Banget  
Kembali LOGIN  
	  
