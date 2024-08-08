# 기능
- [csv 소스](https://openpowerlifting.gitlab.io/opl-csv/bulk-csv.html) 를 이용하여 db에 저장
- Main 클래스를 참조하세요.

# 유의사항
- 실제 remote db 에 저장하려면 DatabaseConfig 파일에서 구체적인 값을 입력하세요.
```
object DatabaseConfig {
    const val URL = ""
    const val USER = ""
    const val PASSWORD = ""
}
```

