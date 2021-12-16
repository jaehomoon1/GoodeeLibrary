--이용가능 도서 조회 / 사용가능(조회)
SELECT b.THUMBNAIL , b.TITLE , b.AUTHORS , b.PUBLISHER , b.CONTENTS 
	FROM BOOK b JOIN BOOK_DETAIL bd
	ON b.BOOK_SEQ = bd.BOOK_SEQ 
	WHERE bd.DAMAGE_SEQ < 4;	

--훼손 도서 신고 / 사용불가(삭제)
UPDATE BOOK_DETAIL bd
	SET DAMAGE_SEQ = 4
	WHERE DETAIL_SEQ = 1;

--훼손 도서 목록 / (조회)
SELECT b.THUMBNAIL , b.TITLE , b.AUTHORS , b.PUBLISHER , b.CONTENTS 
	FROM BOOK b JOIN BOOK_DETAIL bd
	ON b.BOOK_SEQ = bd.BOOK_SEQ 
	WHERE bd.DAMAGE_SEQ = 4;	


/*--훼손 도서 폐기 / 사용불가(관리자 삭제)
DELETE FROM BOOK b
 WHERE b.BOOK_SEQ =  (
        SELECT bd.BOOK_SEQ 
          FROM BOOK_DETAIL bd 
         WHERE b.BOOK_SEQ = bd.BOOK_SEQ 
           AND bd.DAMAGE_SEQ = 4
        );*/







