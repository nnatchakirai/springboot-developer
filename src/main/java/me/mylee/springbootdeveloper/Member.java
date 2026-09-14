package me.mylee.springbootdeveloper;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter //private 멤버변수을 읽어오기 위해 사용
// 위 세개는 코딩 편의를 위해 쓴거임
@Entity
public class Member {
    // 기본키(primary key)가 필요함
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
}
