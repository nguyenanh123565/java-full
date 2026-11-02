package fundamental.variables.exercises.solutions;

public class ReferenceSolution {
    public static void main(String[] args) {
        // assert chỉ phục vụ kiểm chứng; thuật toán bài học không cần rẽ nhánh.
        int sequence = 12;
        long records = 3_000_000_000L;
        double temperature = 26.5;
        char zone = 'A';
        boolean active = true;
        System.out.println(sequence);
        System.out.println(records);
        System.out.println(temperature);
        System.out.println(zone);
        System.out.println(active);
        assert records == 3_000_000_000L;
        records = 0L; assert records == 0L;
        records = 4_000_000_000L; assert records == 4_000_000_000L;
        int raw = 130;
        byte small = (byte) raw;
        int saved = raw;
        raw = 5;
        assert small == -126 && saved == 130 && raw == 5;
        assert (byte) 127 == 127 && (byte) 128 == -128;
        int count = 0;
        long totalRecords = 3_000_000_000L;
        assert count == 0 && totalRecords == 3_000_000_000L;
        int totalSeconds = 3661;
        int hours = totalSeconds / 3600;
        int remainder = totalSeconds - hours * 3600;
        int minutes = remainder / 60;
        int seconds = remainder - minutes * 60;
        assert hours == 1 && minutes == 1 && seconds == 1;
        totalSeconds = 0;
        hours = totalSeconds / 3600; remainder = totalSeconds - hours * 3600;
        minutes = remainder / 60; seconds = remainder - minutes * 60;
        assert hours == 0 && minutes == 0 && seconds == 0;
        totalSeconds = 59;
        hours = totalSeconds / 3600; remainder = totalSeconds - hours * 3600;
        minutes = remainder / 60; seconds = remainder - minutes * 60;
        assert hours == 0 && minutes == 0 && seconds == 59;
        totalSeconds = 3600;
        hours = totalSeconds / 3600; remainder = totalSeconds - hours * 3600;
        minutes = remainder / 60; seconds = remainder - minutes * 60;
        assert hours == 1 && minutes == 0 && seconds == 0;
        totalSeconds = 86400;
        hours = totalSeconds / 3600; remainder = totalSeconds - hours * 3600;
        minutes = remainder / 60; seconds = remainder - minutes * 60;
        assert hours == 24 && minutes == 0 && seconds == 0;
        int crates = 120_000;
        int units = 25_000;
        int snapshot = crates;
        long total = 1L * crates * units;
        double average = (double) total / 2;
        crates = 0;
        assert snapshot == 120_000 && crates == 0 && total == 3_000_000_000L && average == 1_500_000_000.0;
        crates = 200_000; units = 30_000;
        total = 1L * crates * units; average = (double) total / 2;
        assert total == 6_000_000_000L && average == 3_000_000_000.0;
        crates = 0; total = 1L * crates * units;
        assert total == 0;
        System.out.println("VAR: OK");
    }
}
