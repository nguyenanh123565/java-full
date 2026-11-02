# Đối chiếu sau khi tự làm — Working tree → staging → commit

HEAD ghi 120; working tree có 150. Index chứa snapshot 120 nên commit không đọc lại toàn bộ working tree. `git diff` hiển thị 120→150; `git diff --cached` trước commit hiển thị 100→120.

So với dự đoán của bạn: điều nào đúng, điều nào sai, và bằng chứng nào làm bạn đổi cách hiểu? Một câu trả lời dùng thuật ngữ nhưng không giải thích được ví dụ chưa đủ.
