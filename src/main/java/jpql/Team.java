package jpql;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //@BatchSize(size = 100)      // 컬렉션 페치 조인 시 페이징 불가 -> Batch로 해결!
    //persistence.xml에서 글로벌 세팅 가능
    @OneToMany(mappedBy = "team")
    private List<Member> memberList = new ArrayList<>();

    // Getter, Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}
