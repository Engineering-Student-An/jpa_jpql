package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(25);
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            // TypedQuery<제너릭> => 타입정보가 명확하므로 제네릭으로 가짐
//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
//
//            // Query => 타입정보가 명확하지 않음 (username : String, age : int)
//            Query query3 = em.createQuery("select m.username, m.age from Member m");

//            // query.getResultList() : 결과가 컬렉션일 때 => 결과가 없을 때 빈 리스트 반환 (NullPointerException 걱정 x)
//            // query.getSingleResult() : 결과가 1개 일 때 => 결과가 하나가 아닌 (없거나 많으면) 에러 발생!!
//            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//            List<Member> resultList = query.getResultList();
//            Member singleResult = query.getSingleResult();

            // 파라미터 바인딩 (이름 기준)
//            Member singleResult = em.createQuery("select m from Member m where m.username = :name", Member.class)
//                    .setParameter("name", "member1")
//                    .getSingleResult();
//            System.out.println("singleResult = " + singleResult.getUsername());

            // 파라미터 바인딩 (위치 기준) => 웬만하면 사용하지 말기!!

            // 엔티티 프로젝션
//            List<Team> resultList = em.createQuery("select m.team from Member m", Team.class)
//                    .getResultList();
            // => 위의 코드를 쓰는것이 아니라 join 사용해서 써야함 ! (join 을 써야 join 쿼리가 나감을 예측 가능함)
//            List<Team> resultList = em.createQuery("select t from Member m join m.team t", Team.class)
//                    .getResultList();
            // 임베디드 타입 프로젝션 (어디 소속인지를 정해줘야함 (ex. o.address from Order o) => 값 타입의 한계)
//            List<Address> resultList = em.createQuery("select o.address from Order o", Address.class)
//                    .getResultList();
            // 스칼라 타입 프로젝션 (Object[] 타입으로 조회)
//            List<Object[]> resultList = em.createQuery("select distinct m.username, m.age from Member m")
//                    .getResultList();   // 타입을 명기를 못하므로 Object로 반환됨
//            Object[] result = resultList.get(0);
//            System.out.println("result[0] = " + result[0]);
//            System.out.println("result[1] = " + result[1]);

            // 스칼라 타입 프로젝션 (new 명령어로 조회) => 패키지명 포함 클래스명 다 적어줘야함 + 생성자 만들어줘야 함!
//            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//            MemberDTO memberDTO = resultList.get(0);
//            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
//            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());

            // 페이징
//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//            em.flush();
//            em.clear();
//
//            List<Member> result = em.createQuery("select m from Member m order by m.age asc", Member.class)
//                    .setFirstResult(3)  // 조회 시작 위치
//                    .setMaxResults(10)  // 조회할 data 개수
//                    .getResultList();
//            System.out.println("result.size() = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }

            // 조인
//            Team team = new Team();
//            team.setName("team1");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("관리자");
//            member.setAge(10);
//            member.changeTeam(team);
//            member.setType(MemberType.USER);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            // 내부조인 (inner 생략 가능)
//            String query = "select m from Member m inner join m.team t where t.name = :teamName";
            // 외부조인 (outer 생략 가능)
//            String query = "select m from Member m left outer join m.team t where t.name = :teamName";
            // 세타조인 (=막조인)
//            String query = "select m from Member m, Team t where m.username = t.name";

            // 조인 - ON절 (조인 대상 필터링)
//            String query = "select m from Member m left join m.team t on t.name = 'team1'";
            // 조인 - ON절 (연관관계 없는 엔티티 외부 조인)
//            String query = "select m from Member m left join Team t on m.username = t.name";

            // 서브쿼리 - select 절에서
//            String query = "select (select avg(m2.age) from Member m2) as avgAge from Member m join Team t on m.username = t.name";
//
//            List<Member> resultList = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("resultList.size() = " + resultList.size());

            // JPQL 타입 표현
//            String query = "select m.username, 'Hello''s', true from Member m " +
//                    "where m.type = :userType";
//            List<Object[]> result = em.createQuery(query)
//                    .setParameter("userType", MemberType.USER)
//                    .getResultList();
//            for (Object[] objects : result) {
//                System.out.println("objects[0] = " + objects[0]);
//                System.out.println("objects[1] = " + objects[1]);
//                System.out.println("objects[2] = " + objects[2]);
//            }

            // 조건식 - 기본 case 식
//            String query = "select " +
//                                "case when m.age <= 10 then '학생요금' " +
//                                    "when m.age >= 50 then '경로요금' " +
//                                "else '일반요금' " +
//                                "end " +
//                    "from Member m";

            // 조건식 - COALESCE => null이 아니면 첫번째 / null이면 두번째 값 반환
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m";

            // 조건식 - NULLIF => 두 값이 같으면 null / 다르면 첫번째 값 반환
//            String query = "select nullif(m.username, '관리자') from Member m";

            // JPQL 기본함수
            // CONCAT => || 로 대체 가능함 (|| 는 하이버네이트 구현체에서 지원하는 문법임/ concat:JPQL 표준)
//            String query = "select concat('a', m.username) from Member m";
//            String query = "select 'a' || m.username from Member m";
            // SUBSTRING (자를 문자열, 시작 인덱스, 자를 문자개수)
//            String query = "select substring(m.username, 2, 1) from Member m";
            // TRIM (LTRIM, RTRIM) : 공백제거
            // LOWER, UPPER : 소문자, 대문자로 바꿈
            // LENGTH : 문자의 길이
            // LOCATE : 문자열에서 특정 문자열의 위치
//            String query = "select locate('bc', 'abcde') from Member m";
            // SIZE : 양방향 연관관계에서 컬렉션의 크기를 반환
//            String query = "select SIZE(t.memberList) from Team t";
            // INDEX : @OrderColumn (값타입 컬렉션에서 옵션을 부여, 권장 x) 사용할 때 컬렉션의 위치값을 반환
//            String query = "select index(t.memberList) from Team t";

            // 사용자 정의 함수 : DB에서 정의된 함수가 있을 때 해당 함수 사용
            //              (dialect >> MyMySQL8Dialect 생성) (group_concat이라는 사용자 정의 함수가 있다고 가정)
            //              persistence.xml 수정 => hibernate.dialect를 MyMySQL8Dialect로)
//            String query = "select function('group_concat', m.username) from Member m";
//            String query = "select group_concat(m.username) from Member m"; // 하이버네이트 => 가능


//            List<String> resultList = em.createQuery(query, String.class).getResultList();
//            for (String s : resultList) {
//                System.out.println("s = " + s);
//            }

            // 페치 조인
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);
            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.changeTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.changeTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.changeTeam(teamB);
            em.persist(member3);
//
//            em.flush();
//            em.clear();

//            String query = "select m from Member m";
//            // 위의 쿼리 : @ManyToOne(fetch = LAZY)=> 지연로딩 => 팀은 프록시로 들어옴 =>
//            // getName()호출 시점마다 DB에 쿼리 날림
//            // N+1 문제 발생 !!!!
//
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//            for (Member member : result) {
//                System.out.println("member = " + member.getUsername() + " , "
//                        + member.getTeam().getName());
//            }
//            // 루프
//            // 1. 회원1, 팀A (SQL 쿼리 날라감)
//            // 2. 회원2, 팀A (1차캐시에서 조회)
//            // 3. 회원3, 팀B (SQL)

            // 아래의 쿼리로 페치 조인 => N+1 문제 해결 ! (select 쿼리 한 방만 날라감)
            // 조인해서 멤버와 팀을 모두 가져왔기 때문에 팀은 프록시가 아닌 실제 엔티티!
//            String query = "select m from Member m join fetch m.team";

            // 컬렉션 페치 조인
//            String query = "select t from Team t join fetch t.memberList";
            // 중복된 결과 (팀A -> 회원1, 회원2) 가 2번 출력

            // 중복제거 => DISTINCT ==> 같은 식별자를 가진 팀 엔티티를 제거한다!!!!
//            String query = "select distinct t from Team t join fetch t.memberList";

            // 컬렉션 페치 조인 시 페이징 api 사용 해결 (@BatchSize로)
//            String query = "select t from Team t";
            // 멤버 : 지연로딩 => 끌고 올 때 내 팀 뿐만 아니라 아래의 리스트로 가져왔던 팀을 한 번에 in 쿼리로 100개씩 넘김
//            List<Team> result = em.createQuery(query, Team.class)
//                    .setFirstResult(0)
//                    .setMaxResults(2)
//                    .getResultList();
//            for (Team team : result) {
//                System.out.println("team = " + team.getName() + " , " + team.getMemberList().size());
//                for(Member member : team.getMemberList()){
//                    System.out.println("member = " + member);
//                }
//            }

            // 엔티티 직접 사용 - 기본키
//            String query = "select m from Member m where m = :member";
            // 엔티티 직접 사용 - 외래 (@JoinColumn 으로 매핑된 외래키 그대로 사용 => TEAM_ID)
//            String query = "select m from Member m where m.team = :team";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .setParameter("team", teamA)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }

            // Named 쿼리
//            List<Member> resultList = em.createNamedQuery("Member.findByUserName", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();
//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//            }

            // 벌크 연산 (flush는 자동으로 호출됨)
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();   // 영향을 받은 엔티티 수를 반환

            em.clear(); // 벌크연산 : DB에 한방쿼리로 직접 반영하므로 영속성 컨텍스트 초기화해야 함!

//            System.out.println("resultCount = " + resultCount);
//
//            // 이 시점에는 update 한 데이터가 영속성 컨텍스트에 반영이 안되므로 0으로 출력됨!
            Member findMember = em.find(Member.class, member1.getId()); // 영속성 컨텍스트가 비어있으므로 DB에서 새로 조회해옴 => update 쿼리가 반영됨!
            System.out.println("findMember.getAge() = " + findMember.getAge());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
