# Tiêu chí đối chiếu

Unit không cần Spring; MVC kiểm hợp đồng HTTP; DB integration kiểm SQL/constraint.
Một ca tạo order gồm hai item mà item hai thiếu stock phải quan sát không có order
và stock item một không bị trừ sau rollback. Case đó cần DB thật và transaction thật,
không thể chứng minh chỉ bằng verify(repository.save(...)).
