--CREATE USER mini IDENTIFIED BY mini;
--GRANT CONNECT, RESOURCE TO mini;
--GRANT CREATE VIEW TO mini;
--GRANT CREATE SEQUENCE TO mini;
--GRANT CREATE TRIGGER TO mini;

DROP TABLE STUDENT CASCADE CONSTRAINTS;
DROP TABLE STUDENT_DEL CASCADE CONSTRAINTS;
DROP TABLE PROFESSOR CASCADE CONSTRAINTS;
DROP TABLE DEPARTMENT CASCADE CONSTRAINTS;
DROP TABLE LECTURE CASCADE CONSTRAINTS;
DROP TABLE ENROLLMENT CASCADE CONSTRAINTS;
DROP TABLE LECTURE_JUG CASCADE CONSTRAINTS;
DROP TABLE GRADE CASCADE CONSTRAINTS;

CREATE TABLE DEPARTMENT(
    DEPT_CODE VARCHAR2(10) PRIMARY KEY,
    DEPT_NAME VARCHAR2(50)
    );
    
COMMENT ON COLUMN DEPARTMENT.DEPT_CODE IS '학과코드';
COMMENT ON COLUMN DEPARTMENT.DEPT_NAME IS '학과명';

CREATE TABLE STUDENT
    (
    STUDENT_NO NUMBER(10),
    DEPT_CODE VARCHAR2(10),
    STUDENT_ID VARCHAR2(20),
    STUDENT_PWD VARCHAR2(20) NOT NULL,
    STUDENT_NAME VARCHAR2(15) NOT NULL,
    ADDRESS VARCHAR2(100),
    STUDENT_TELNO VARCHAR2(15) NOT NULL,
    EMAIL VARCHAR2(100),
    ENROLL_DATE DATE DEFAULT SYSDATE,
    STATUS CHAR(2) DEFAULT 'N'
    );
    
COMMENT ON COLUMN STUDENT.STUDENT_NO IS '학생번호';
COMMENT ON COLUMN STUDENT.DEPT_CODE IS '학과코드';
COMMENT ON COLUMN STUDENT.STUDENT_ID IS '학생아이디';
COMMENT ON COLUMN STUDENT.STUDENT_PWD IS '학생비밀번호';
COMMENT ON COLUMN STUDENT.STUDENT_NAME IS '학생이름';
COMMENT ON COLUMN STUDENT.ADDRESS IS '학생주소';
COMMENT ON COLUMN STUDENT.STUDENT_TELNO IS '학생전화번호';
COMMENT ON COLUMN STUDENT.EMAIL IS '학생이메일';
COMMENT ON COLUMN STUDENT.ENROLL_DATE IS '입학일';
COMMENT ON COLUMN STUDENT.STATUS IS '재학상태';

ALTER TABLE STUDENT ADD CONSTRAINT PK_STUDENT_NO PRIMARY KEY (STUDENT_NO);
ALTER TABLE STUDENT ADD CONSTRAINT UQ_STUDENT_ID UNIQUE (STUDENT_ID);
ALTER TABLE STUDENT ADD CONSTRAINT CK_STATUS_01 CHECK(STATUS IN('Y', 'N'));
ALTER TABLE STUDENT ADD CONSTRAINT FK_DEPT_01 FOREIGN KEY (DEPT_CODE) REFERENCES DEPARTMENT(DEPT_CODE);

CREATE TABLE STUDENT_DEL
    (
    STUDENT_NO NUMBER(10),
    DEPT_CODE VARCHAR2(10),
    STUDENT_ID VARCHAR2(20),
    STUDENT_PWD VARCHAR2(20) NOT NULL,
    STUDENT_NAME VARCHAR2(15) NOT NULL,
    ADDRESS VARCHAR2(100),
    STUDENT_TELNO VARCHAR2(15) NOT NULL,
    EMAIL VARCHAR2(100),
    ENROLL_DATE DATE,
    DEL_DATE DATE DEFAULT SYSDATE,
    STATUS CHAR(2)
    );
    
COMMENT ON COLUMN STUDENT_DEL.STUDENT_NO IS '학생번호';
COMMENT ON COLUMN STUDENT_DEL.DEPT_CODE IS '학과코드';
COMMENT ON COLUMN STUDENT_DEL.STUDENT_ID IS '학생아이디';
COMMENT ON COLUMN STUDENT_DEL.STUDENT_PWD IS '학생비밀번호';
COMMENT ON COLUMN STUDENT_DEL.STUDENT_NAME IS '학생이름';
COMMENT ON COLUMN STUDENT_DEL.ADDRESS IS '학생주소';
COMMENT ON COLUMN STUDENT_DEL.STUDENT_TELNO IS '학생전화번호';
COMMENT ON COLUMN STUDENT_DEL.EMAIL IS '학생이메일';
COMMENT ON COLUMN STUDENT_DEL.ENROLL_DATE IS '입학일';
COMMENT ON COLUMN STUDENT_DEL.DEL_DATE IS '탈퇴일';
COMMENT ON COLUMN STUDENT_DEL.STATUS IS '재학상태';

ALTER TABLE STUDENT_DEL ADD CONSTRAINT FK_STUDENT_NO FOREIGN KEY(STUDENT_ID) REFERENCES STUDENT(STUDENT_ID);

CREATE TABLE PROFESSOR
    (
    PROF_NO NUMBER(10),
    DEPT_CODE VARCHAR2(10),
    PROF_ID VARCHAR2(20),
    PROF_PWD VARCHAR2(20) NOT NULL,
    PROF_NAME VARCHAR2(15) NOT NULL,
    ADDRESS VARCHAR2(100),
    PROF_TELNO VARCHAR2(15) NOT NULL,
    EMAIL VARCHAR2(100),
    ENROLL_DATE DATE DEFAULT SYSDATE,
    STATUS CHAR(2) DEFAULT 'N'
    );
    
COMMENT ON COLUMN PROFESSOR.PROF_NO IS '교수번호';
COMMENT ON COLUMN PROFESSOR.DEPT_CODE IS '학과코드';
COMMENT ON COLUMN PROFESSOR.PROF_ID IS '교수아이디';
COMMENT ON COLUMN PROFESSOR.PROF_PWD IS '교수비밀번호';
COMMENT ON COLUMN PROFESSOR.PROF_NAME IS '교수이름';
COMMENT ON COLUMN PROFESSOR.ADDRESS IS '교수주소';
COMMENT ON COLUMN PROFESSOR.PROF_TELNO IS '교수전화번호';
COMMENT ON COLUMN PROFESSOR.EMAIL IS '교수이메일';
COMMENT ON COLUMN PROFESSOR.ENROLL_DATE IS '입학일';
COMMENT ON COLUMN PROFESSOR.STATUS IS '재직상태';

ALTER TABLE PROFESSOR ADD CONSTRAINT PK_PROF_NO PRIMARY KEY (PROF_NO);
ALTER TABLE PROFESSOR ADD CONSTRAINT UQ_PROF_ID UNIQUE (PROF_ID);
ALTER TABLE PROFESSOR ADD CONSTRAINT CK_STATUS_02 CHECK(STATUS IN('Y', 'N'));
ALTER TABLE PROFESSOR ADD CONSTRAINT FK_DEPT_02 FOREIGN KEY (DEPT_CODE) REFERENCES DEPARTMENT(DEPT_CODE);

CREATE TABLE LECTURE (
    LECTURE_NO NUMBER(10),
    DEPT_CODE VARCHAR2(10),
    PROF_NO NUMBER(10),
    LECTURE_NAME VARCHAR2(30),
    CREDIT CHAR(1),
    CURR_NO NUMBER(2),
    FULL_NO NUMBER(2) NOT NULL,
    "DAY" VARCHAR2(10) NOT NULL,
    "TIME" VARCHAR2(10) NOT NULL
    );

COMMENT ON COLUMN LECTURE.LECTURE_NO IS '강의번호';
COMMENT ON COLUMN LECTURE.DEPT_CODE IS '학과코드';
COMMENT ON COLUMN LECTURE.PROF_NO IS '교수번호';
COMMENT ON COLUMN LECTURE.LECTURE_NAME IS '강의명';
COMMENT ON COLUMN LECTURE.CREDIT IS '수강학점';
COMMENT ON COLUMN LECTURE.CURR_NO IS '수강인원';
COMMENT ON COLUMN LECTURE.FULL_NO IS '정원인원';
COMMENT ON COLUMN LECTURE."DAY" IS '요일';
COMMENT ON COLUMN LECTURE."TIME" IS '시간';

ALTER TABLE LECTURE ADD CONSTRAINT PK_LECTURE PRIMARY KEY (LECTURE_NO);
ALTER TABLE LECTURE ADD CONSTRAINT CK_CREDIT CHECK(CREDIT BETWEEN 1 AND 3);
ALTER TABLE LECTURE ADD CONSTRAINT FK_DEPT_03 FOREIGN KEY (DEPT_CODE) REFERENCES DEPARTMENT(DEPT_CODE);
ALTER TABLE LECTURE ADD CONSTRAINT FK_PROF_01 FOREIGN KEY (PROF_NO) REFERENCES PROFESSOR(PROF_NO);

CREATE TABLE ENROLLMENT(
    ENROLL_ID NUMBER(10),
    STUDENT_NO NUMBER(10),
    LECTURE_NO NUMBER(10)
    );
    
COMMENT ON COLUMN ENROLLMENT.ENROLL_ID IS '수강신청번호';
COMMENT ON COLUMN ENROLLMENT.STUDENT_NO IS '학번';
COMMENT ON COLUMN ENROLLMENT.LECTURE_NO IS '강의번호';
    
ALTER TABLE ENROLLMENT ADD CONSTRAINT PK_ENROLLMENT PRIMARY KEY (ENROLL_ID);
ALTER TABLE ENROLLMENT ADD CONSTRAINT FK_STUDENT_NO_01 FOREIGN KEY (STUDENT_NO) REFERENCES STUDENT(STUDENT_NO);
ALTER TABLE ENROLLMENT ADD CONSTRAINT FK_LECT_01 FOREIGN KEY (LECTURE_NO) REFERENCES LECTURE(LECTURE_NO);   
    
CREATE TABLE LECTURE_JUG (
    JUDGEMENT_NO NUMBER(10),
    LECTURE_NO NUMBER(10),
    STUDENT_NO NUMBER(10),
    PROF_NO NUMBER(10),
    STU_JUG_SCORE NUMBER(10), -- CHECK (STU_JUG_SCORE BETWEEN 1 AND 5),
    STU_ONE_JUG VARCHAR2(100)
    );

COMMENT ON COLUMN LECTURE_JUG.JUDGEMENT_NO IS '강의 평가 번호';
COMMENT ON COLUMN LECTURE_JUG.LECTURE_NO IS '강의 번호';
COMMENT ON COLUMN LECTURE_JUG.STUDENT_NO IS '학번';
COMMENT ON COLUMN LECTURE_JUG.PROF_NO IS '교수 번호';
COMMENT ON COLUMN LECTURE_JUG.STU_JUG_SCORE IS '학생 만족도 점수';
COMMENT ON COLUMN LECTURE_JUG.STU_ONE_JUG IS '학생 한줄 평가';

ALTER TABLE LECTURE_JUG ADD CONSTRAINT PK_LECTURE_JUG PRIMARY KEY (JUDGEMENT_NO);
ALTER TABLE LECTURE_JUG ADD CONSTRAINT FK_STUDENT_NO_02  FOREIGN KEY (STUDENT_NO) REFERENCES STUDENT(STUDENT_NO);
ALTER TABLE LECTURE_JUG ADD CONSTRAINT FK_LECT_02 FOREIGN KEY (LECTURE_NO) REFERENCES LECTURE(LECTURE_NO);   
ALTER TABLE LECTURE_JUG ADD CONSTRAINT FK_PROF_02 FOREIGN KEY (PROF_NO) REFERENCES PROFESSOR(PROF_NO);   

CREATE TABLE GRADE (
    GRADE_NO NUMBER(10),
    LECTURE_NO NUMBER(10),
    PROF_NO NUMBER(10),
    STUDENT_NO NUMBER(10),
    ATT_SCORE NUMBER(3),
    ASS_SCORE NUMBER(3),
    MID_SCORE NUMBER(3),
    FIN_SCORE NUMBER(3),
    GRADE VARCHAR2(5)
    );
    
COMMENT ON COLUMN GRADE.GRADE_NO IS '학점 번호';
COMMENT ON COLUMN GRADE.LECTURE_NO IS '강의 번호';
COMMENT ON COLUMN GRADE.PROF_NO IS '교수 번호';
COMMENT ON COLUMN GRADE.STUDENT_NO IS '학번';
COMMENT ON COLUMN GRADE.ATT_SCORE IS '출석점수';
COMMENT ON COLUMN GRADE.ASS_SCORE IS '과제점수';
COMMENT ON COLUMN GRADE.MID_SCORE IS '중간점수';
COMMENT ON COLUMN GRADE.FIN_SCORE IS '기말점수';
COMMENT ON COLUMN GRADE.GRADE IS '학번';
    
ALTER TABLE GRADE ADD CONSTRAINT PK_GRADE_NO PRIMARY KEY (GRADE_NO);
ALTER TABLE GRADE ADD CONSTRAINT FK_STUDENT_NO_03  FOREIGN KEY (STUDENT_NO) REFERENCES STUDENT(STUDENT_NO);
ALTER TABLE GRADE ADD CONSTRAINT FK_LECT_03 FOREIGN KEY (LECTURE_NO) REFERENCES LECTURE(LECTURE_NO);   
ALTER TABLE GRADE ADD CONSTRAINT FK_PROF_03 FOREIGN KEY (PROF_NO) REFERENCES PROFESSOR(PROF_NO); 
ALTER TABLE GRADE ADD CONSTRAINT CK_SCORE_01 CHECK(ATT_SCORE BETWEEN 0 AND 10);
ALTER TABLE GRADE ADD CONSTRAINT CK_SCORE_02 CHECK (ASS_SCORE BETWEEN 0 AND 30);
ALTER TABLE GRADE ADD CONSTRAINT CK_SCORE_03 CHECK (MID_SCORE BETWEEN 0 AND 30);
ALTER TABLE GRADE ADD CONSTRAINT CK_SCORE_04 CHECK (FIN_SCORE BETWEEN 0 AND 30);
    
    
    