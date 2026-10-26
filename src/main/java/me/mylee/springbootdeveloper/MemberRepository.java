package me.mylee.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    Member findByName();
    // findAll() : select * from member;
    // findById() : select * from member where id = ?
    // deleteAll() : delete form member;
    // deleteById(): delete from member where id = ?
    // save(): insert into member(id, name) values (?, ?), update member sat ... where id = ?

    // findByName() : select * from member where name = ?
   // public List<Member> findByName(String name);
    public Optional<Member> findByName(String name);
    // select * from member where name = ? limit 1 : Top-N query

    // findByEmail() : select * from member where email = ?
    //public Optional<Member> findByEmail(String email);

    // findByNameAndEmail() : select * from member
    //public Optional<Member> findByNameAndEmail(String name, String email);
}
