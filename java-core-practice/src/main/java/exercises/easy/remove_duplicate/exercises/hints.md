# Gợi ý theo mức

Mở từng mức sau khi đã ghi lại điều đang mắc.

## DUP-01

<details><summary>Mức 1 — hướng suy nghĩ</summary>

Tách giá trị biến khỏi dữ liệu được tham chiếu.

</details>

<details><summary>Mức 2 — bước tiếp theo</summary>

Ghi trạng thái trước so sánh và ngay sau cập nhật.

</details>

## DUP-02

<details><summary>Mức 1 — hướng suy nghĩ</summary>

Tìm đầu vào nhỏ nhất làm kết quả sai.

</details>

<details><summary>Mức 2 — bước tiếp theo</summary>

HashSet không bảo đảm thứ tự. Dùng LinkedHashSet hoặc duyệt nguồn và set kiểm đã gặp. Không lấy một output tình cờ làm hợp đồng.

</details>

## DUP-03

<details><summary>Mức 1 — hướng suy nghĩ</summary>

Viết hợp đồng và làm tay ví dụ trước.

</details>

<details><summary>Mức 2 — bước tiếp theo</summary>

Đếm vào LinkedHashMap theo lượt đầu rồi duyệt entry có count>=2. Với report, Set cho distinct và repeated().length cho Y.

</details>

## DUP-04

<details><summary>Mức 1 — hướng suy nghĩ</summary>

Tách xử lý một dữ liệu khỏi vòng lặp tạo báo cáo.

</details>

<details><summary>Mức 2 — bước tiếp theo</summary>

Tái dùng hàm bài 03; quyết định kết quả rỗng trước khi in.

</details>
