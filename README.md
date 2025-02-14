# Module 1  

## Reflection

### Reflection 1
**Question:**  
*You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code. If you find any mistake in your source code, please explain how to improve your code.*

**Reflection:**  
Pada awalnya saya cukup kewalahan dengan framework dan IDE baru yang digunakan. Beberapa permasalahan yang saya alami antara lain pesan error yang tidak memberikan keterangan yang jelas dan IDE yang lag karena terlalu berat. Namun, seiring waktu saya mulai beradaptasi dengan lingkungan pengembangan tersebut.  
Tutorial dari modul sangat membantu dalam pembuatan source code yang memenuhi standar coding, sehingga source code saya sudah menerapkan prinsip-prinsip seperti clean code, git flow, dan testing.  
Meski begitu, saya menyadari bahwa terdapat kelemahan dari sisi secure coding, karena input pada form belum divalidasi dan disanitasi, sehingga rentan terhadap injection. **Improvement** yang bisa saya lakukan adalah menerapkan validasi dan sanitasi input untuk meningkatkan keamanan, serta memperbaiki tampilan/template agar lebih menarik dan konsisten.

---

### Reflection 2
**Question:**  
*After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?  
Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.*

**Reflection:**  
Setelah menyelesaikan penulisan unit test dan seluruh test berhasil pass, saya merasa sangat senang. Namun, saya juga menyadari bahwa jumlah test yang dilakukan masih terbatas, sehingga test perlu ditambahkan—namun tidak berlebihan. Yang penting adalah memastikan bahwa test memiliki code coverage yang luas, bukan hanya mengejar persentase tinggi tanpa mempertimbangkan kualitas tes. Meskipun code coverage 100% berarti setiap baris kode telah dijalankan, hal itu tidak menjamin bahwa kode bebas dari bugs atau errors.

Mengenai pembuatan functional test suite baru untuk verifikasi jumlah produk, jika saya membuat kelas Java baru, saya akan mengulang inisiasi variabel, endpoint, port, import, dan kode untuk membuka web yang sudah ada di CreateProductFunctionalTest.java. Hal ini jelas melanggar prinsip clean code karena menyebabkan duplikasi.  
Sebagai improvement, saya dapat menyatukan test tersebut dalam satu kelas dengan method yang berbeda. Misalnya, saya dapat mendefinisikan variabel `jumlahProduk` yang akan bertambah satu setiap kali proses create berhasil, dan saat melakukan verifikasi jumlah produk, nilai `jumlahProduk` dibandingkan dengan konten tag `<td>` HTML yang muncul.
