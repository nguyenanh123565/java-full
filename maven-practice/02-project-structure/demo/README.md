# Demo — theo dõi một resource

Xem [resource](../../01-why-build-tool/demo/project/src/main/resources/app.properties) và [Main](../../01-why-build-tool/demo/project/src/main/java/learning/Main.java).

Khi tự build trong project: `mvn compile`, kiểm tra `target/classes/learning/Main.class` và `target/classes/app.properties`. Sau `mvn package`, dùng `jar tf target/product-total-1.0.0.jar` xem chúng nằm trong artifact. Không sửa target để thay source.
