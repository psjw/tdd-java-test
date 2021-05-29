package com.ljw.tddjavatest;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
//클래스에 사용시 모든 메서드에 적용 -> UnderScore를 빈공백으로 치환
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {



    //JUnit 5부터는 public 없어도됨
    @Test
    @DisplayName("스터디 만들기")
    void create_new_study1(){
        Study study = new Study(-10);
        assertNotNull(study);

        //첫번째 assert에서 실패가나면 아래의 assert는 수행하지 않아 성공여부를 모름 -> assertAll로 묶어줌
        assertTrue(study.getLimit()>0,"스터디 참석가능 인원은 0보다 커야한다.");

        //기대값, 실제 값
//        assertEquals(StudyStatus.DRAFT, study.getStatus(),"스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        //기대값, 실제 값,  Supplyer타입
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
//            @Override
//            public String get() {
//                return "스터디를 처음 만들면 DRAFT 상태다.";
//            }
//        });
        assertEquals(StudyStatus.DRAFT, study.getStatus(),() -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        //왜 lambda쓰지?
        //만약 메시지가 "스터디를 처음 만들면 상태값이"+  StudyStatus.DRAFT+"여야 한다." -> String 값인 경우 실패여부 상관없이 매번 실행
        //만약 Supplier로 수행시 ()->"스터디를 처음 만들면 상태값이"+  StudyStatus.DRAFT+"여야 한다." -> String 값이 실패할 경우에만 실행


        System.out.println("create");
    }


    //JUnit 5부터는 public 없어도됨
    @Test
    @DisplayName("스터디 만들기")
    void create_new_study(){
        Study study = new Study(-10);
        assertNotNull(study);

        assertAll(
                () ->assertNotNull(study),
                ()-> assertTrue(study.getLimit()>0,"스터디 참석가능 인원은 0보다 커야한다."),
                () ->assertEquals(StudyStatus.STARTED,study.getStatus(),"스터디를 처음 만들면 상태값이 DRAFT여야 한다.")
        );

        
        //첫번째 assert에서 실패가나면 아래의 assert는 수행하지 않아 성공여부를 모름 -> assertAll로 묶어줌
        assertTrue(study.getLimit()>0,"스터디 참석가능 인원은 0보다 커야한다.");

        //기대값, 실제 값
//        assertEquals(StudyStatus.DRAFT, study.getStatus(),"스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        //기대값, 실제 값,  Supplyer타입
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
//            @Override
//            public String get() {
//                return "스터디를 처음 만들면 DRAFT 상태다.";
//            }
//        });
        assertEquals(StudyStatus.DRAFT, study.getStatus(),() -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        //왜 lambda쓰지?
        //만약 메시지가 "스터디를 처음 만들면 상태값이"+  StudyStatus.DRAFT+"여야 한다." -> String 값인 경우 실패여부 상관없이 매번 실행
        //만약 Supplier로 수행시 ()->"스터디를 처음 만들면 상태값이"+  StudyStatus.DRAFT+"여야 한다." -> String 값이 실패할 경우에만 실행


        System.out.println("create");
    }

    @Test
    //@Disabled //실행하고 싶지 않을경우 //Ignored
    void create_new_study_again(){
        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals("limit은 0보다 커야한다.",message);
        System.out.println("create1");
    }

    @Test
    void create_new_study_again1(){
        //실제 메서드가 수행될 때까지 대기
        assertTimeout(Duration.ofMillis(100),()->{
            new Study(10);
            Thread.sleep(300);
        });
    }

    @Test
    void create_new_study_again2(){
        //100 ms세컨까지만 기다림
        assertTimeoutPreemptively(Duration.ofMillis(100),()->{
            new Study(10);
            Thread.sleep(300);
        });
        // TODO ThreadLocal  사용시 예상치 못한 결과가 일어날수 있음(ex. SpringTransaction 다른쓰레드에서는 공유가안됨, 스프링 트랜젝션 설정이 제대로 공유안될수 있음, 롤백이 안되고 DB에 반영될수 있음)
    }

    @Test
    void create_new_study_again3(){
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }


    @BeforeAll  //테스트를 실행하기 전 한번만 호출 , static메서드 사용, private는 안됨 , return 타입 안됨
    //BeforeClass
   static void beforeAll(){
        System.out.println("before all");
    }

    @AfterAll //테스트 실행한 후 한번만 호출 , static메서드 사용, private는 안됨 , return 타입 안됨
    //AfterClass
    static void afterAll(){
        System.out.println("after all");
    }

    @BeforeEach // 각각의 테스트 실행하기 이전에 호출 , static일 필요 없음
    //Before
    void beforeEach(){
        System.out.println("Before each");
    }

    @AfterEach// 각각의 테스트 실행한 이후 호출 , static일 필요 없음
        // After
    void afterEach(){
        System.out.println("After each");
    }

    

}