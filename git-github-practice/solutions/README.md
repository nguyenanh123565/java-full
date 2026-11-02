# Định hướng bài tổng hợp — mở sau khi tự làm

Một chuỗi hợp lý: commit seed → tách feature → commit khác nhau ở hai nhánh → đọc graph → merge → kiểm tra Java → push bare remote → clone peer → commit/push peer → fetch và tích hợp ở bản đầu. Khi conflict, dùng yêu cầu nghiệp vụ quyết định nội dung cuối rồi stage và commit. `status` sạch không chứng minh hành vi đúng; cần kiểm tra thực thi và contract.

Bằng chứng cần có: `git log --all --graph --oneline`, hai loại diff, ignore rule được kiểm tra, bản nháp PR mô tả request HTTP và query SQL. DB runtime nằm ngoài repo; source được push chưa làm server runtime thay đổi.
