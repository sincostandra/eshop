# Module 1  

## Reflection

### Reflection 1
**Question:**  
*You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code. If you find any mistake in your source code, please explain how to improve your code.*

**Reflection:**  
Pada awalnya saya cukup kewalahan dengan framework dan IDE baru yang digunakan. Beberapa permasalahan yang saya alami antara lain pesan error yang tidak memberikan keterangan yang jelas dan IDE yang lag karena terlalu berat. Namun, seiring waktu saya mulai beradaptasi dengan IDE tersebut.  
Tutorial dari modul sangat membantu dalam pembuatan source code yang memenuhi standar coding, sehingga source code saya sudah menerapkan prinsip-prinsip seperti clean code, git flow, dan testing.  
Meski begitu, saya menyadari bahwa terdapat kelemahan dari sisi secure coding, karena input pada form belum divalidasi dan disanitasi, sehingga rentan terhadap injection. **Improvement** yang bisa saya lakukan adalah menerapkan validasi dan sanitasi input untuk meningkatkan keamanan, serta memperbaiki tampilan/template agar lebih menarik.

---

### Reflection 2
**Question:**  
*After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?  
Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.*

**Reflection:**  
Setelah menyelesaikan penulisan unit test dan seluruh test berhasil pass, saya merasa senang. Saya juga menyadari bahwa jumlah test yang dilakukan masih terbatas, sehingga test perlu ditambahkan—namun tidak berlebihan. Yang penting adalah memastikan bahwa test memiliki code coverage yang luas, namum juga mempertimbangkan kualitas tes. Meskipun code coverage 100% berarti setiap baris kode telah dijalankan, hal itu tidak menjamin bahwa kode bebas dari bugs atau errors.  

Jika saya membuat class java baru untuk melakukan tes verifikasi jumlah produk, itu akan mengulang apa yang saya tulis pada CreateProductFunctionalTest.java seperti inisiasi variabl, endpoint, port, import, dan kode untuk masuk web. Tentunya ini akan merusak clean code, karena kita jadi menulis hal 2x yang sebenernya tidak dibutuhkan, salah satu improvmenet yang bisa saya lakukan mungkin dengan menyatukan testnya dalam satu class namun dengan method yang berbeda, misal inisiasi variabel jumlahProduk, setiap kali create berhasil, akan ditambahkan satu, dan ketika menjalankan verifikasi jumlah produk, akan membandingkan variabel jumlahProduk dengan tag td html yang muncul  


---  

# Module 2
### Reflection 1
**Question:**
*List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.*  

**Reflection:**  
Pada awalnya, saya memperbaiki direktori tes yang tidak sesuai. Karena Minggu lalu, saya meletakkan direktori tes untuk edit dan delete di package controller test, yang menyebabkan kode saya menjadi tidak teratur. Namun pada minggu ini, saya telah menempatkannya dengan benar di package repository test.

Selain itu, terdapat permasalahan pada kode controller yang saya buat. Sebelumnya, saya menggunakan looping untuk mencari item, namun saya merevisinya dengan mengganti metode tersebut menggunakan HashMap. Dengan perubahan ini, code coverage saya berhasil mencapai 100%. Saya juga melakukan beberapa revisi sesuai saran dari PMD, seperti menghapus unused import dan menyesuaikan modifiers yang tidak sesuai.  

**Question**:
**Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!**  

**Reflection:**  
Saya rasa ci/cd workflows yang saya buat sudah sesuai dengan definisi dari CI/CD itu sendiri. Terdapat 2 CI workflows yang saya implementasikan
1. CI pertama adalah untuk mengecek apakah jika saya mengubah kode yang ada, fitur-fitur yang lain akan kena dampak sehingga menimbulkan error? (hal ini dilakukan dengan testing secara otomatis ketika ada push atau pull req)
2. CI yang kedua adalah pengecekan terhadap kualitas dan potensi kerentanan dari kode yang baru dibuat, hal ini tentunya demi menjaga prinsip clean code.

Untuk CD, saya menggunakan koyeb sehingga konfigurasinya sdh diatur ke koyeb, jadi setiap kali saya melakukan push/pull req ke branch main, akan langsung dideteksi oleh server koyeb dan secara otomatis dideploy ke server
