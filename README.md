# hcmus-chatchit

Thông tin sinh viên: 20424051 - Nguyễn Thành Long - thafnhlong@gmail.com

## Hường dẫn setup project:

### Cài đặt JDK16:

- Truy cập link : https://jdk.java.net/16/
- Chọn dòng: [Windows / x64	zip (sha256)](https://download.java.net/java/GA/jdk16.0.1/7147401fd7354114ac51ef3e1328291f/9/GPL/openjdk-16.0.1_windows-x64_bin.zip)
![image](https://user-images.githubusercontent.com/33834505/121699079-d2119580-caf8-11eb-8615-e3a20517e216.png)
- Tiến hành giải nén và [cài đặt biến PATH](https://shareprogramming.net/cach-dat-bien-moi-truong-java_home-trong-windows-10/) với thư mục chứa file java.exe

### Compiler Project:

- Truy cập vào thư mục SRC của project
- Đánh lệnh
```
  javac Main.java -d ../build
```
![image](https://user-images.githubusercontent.com/33834505/121701862-8c0a0100-cafb-11eb-8ae0-42b573b3b8e3.png)

### Run App:

- Vào thư mục build ở trên
- Để start server t đánh lệnh
```
  java Main sv
```
![image](https://user-images.githubusercontent.com/33834505/121702224-e3a86c80-cafb-11eb-8435-cf248fff9fcd.png)

- Để start client ta đánh lệnh ( nếu máy khách java encoding mặc định không phải utf8 thì phải thêm cờ -Dfile.encoding=UTF-8 )
```
  java -Dfile.encoding=UTF-8 Main
```
![image](https://user-images.githubusercontent.com/33834505/121702366-0470c200-cafc-11eb-8e84-c0fb6c26cfec.png)


## Chức năng hiện có của project:

- Lựa chọn PORT server để chat và để tải file riêng lẻ => Tăng hiệu quả
- Đăng ký tài khoản
- Chống đăng ký trùng tài khoản
- Đăng nhập với tài khoản đã đăng ký
- Đăng xuất tài khoản
- Đa luồng tải file, nhắn tin
- Không block ứng dụng khi upload/download file
- Chat
- Chat có emoji
- Chat group
- Gửi file và nhận file
- Gửi hình và nhận hình

# Một số hình ảnh sử dụng với azure vm:
![1](https://user-images.githubusercontent.com/33834505/121703143-b90ae380-cafc-11eb-9b2f-4853ecb266d4.png)
![3](https://user-images.githubusercontent.com/33834505/121703141-b8724d00-cafc-11eb-8956-94a24638cf6f.png)
![2](https://user-images.githubusercontent.com/33834505/121703131-b6a88980-cafc-11eb-9c9a-b1de4015abcc.png)

