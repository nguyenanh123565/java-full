# Demo Bash — chỉ tạo thư mục tạm

```bash
LAB=$(mktemp -d)
mkdir "$LAB/data" "$LAB/logs"
printf 'Book\n' > "$LAB/data/item.txt"
printf '%s\n' "$LAB"
pwd
ls -la "$LAB"
cat "$LAB/data/item.txt"
cd "$LAB/data"
pwd
cat item.txt
```

Mở terminal thử riêng để cd không ảnh hưởng buổi làm việc khác. Không xóa/sửa file hiện có. Dự đoán lỗi nếu tiếp tục dùng `cat data/item.txt` từ data/.
