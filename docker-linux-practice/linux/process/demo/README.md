# Demo Bash — process do bạn tạo

```bash
sleep 30 &
LAB_PID=$!
printf 'Created PID: %s\n' "$LAB_PID"
ps -p "$LAB_PID" -o pid,comm,args
kill -TERM "$LAB_PID"
wait "$LAB_PID"
```

`wait` có thể trả exit status biểu thị bị TERM; đây là dự kiến. Đừng thay LAB_PID bằng PID của app thật. Demo không dùng kill theo pattern và không cần sudo.
