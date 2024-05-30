package com.jpms.codinggame.service;

import com.jpms.codinggame.dto.QuestionResDto;
import com.jpms.codinggame.entity.Question;
import com.jpms.codinggame.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final RedisService redisService;

    /*
    * 당일 생성 된 문제 가져오기
    * */
    public List<QuestionResDto> getQuestionList(int volume){
        List<Question> questionList = questionRepository.findAllByDate(LocalDate.now()).subList(0,volume);
//        redisService.put("test1","key1",11);
//        redisService.put("test1","key2","fifi");
//        System.out.println(redisService.get("test1","key1"));
//        System.out.println(redisService.get("test1","key2"));

        return questionList
                .stream()
                .map(question -> QuestionResDto
                        .builder()
                        .questionNo(question.getQuestionNo())
                        .content(question.getContent())
                        .answer(question.getAnswer())
                        .build())
                .toList();
    }

    /*
    * 틀린 문제 가져오기
    * */
//    public List<QuestionResDto> getIncorrectQuestionList(){
//
//    }

    /*
    * 유형별 문제 가져오기
    * */
    public List<QuestionResDto> getQuestionListByType(String questionType){
        List<Question> questionList = questionRepository
                .findAllQuestionByDateAndType(questionType,LocalDate.now());
        return questionList
                .stream()
                .map(question -> QuestionResDto
                        .builder()
                        .questionNo(question.getQuestionNo())
                        .content(question.getContent())
                        .choice(question.getAnswer())
                        .answer(question.getAnswer())
                        .build())
                .toList();
    }
}
