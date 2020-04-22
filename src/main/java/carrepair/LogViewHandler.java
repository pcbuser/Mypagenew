package carrepair;

import carrepair.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LogViewHandler {


    @Autowired
    private LogRepository logRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAcceptPlaced_then_CREATE_1 (@Payload AcceptPlaced acceptPlaced) {
        try {
            if (acceptPlaced.isMe()) {
                // view 객체 생성
                Log log = new Log();
                // view 객체에 이벤트의 Value 를 set 함
                log.setAcceptid(acceptPlaced.getId());
                log.setCarno(acceptPlaced.getCarno());
                log.setCarname(acceptPlaced.getCarname());
                log.setOwnername(acceptPlaced.getOwnername());
                log.setStatus("01");
                //log.setStatus(acceptPlaced.getStatus()); 등록시만 남김
                // view 레파지 토리에 save
                logRepository.save(log);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

/**
    @StreamListener(KafkaProcessor.INPUT)
    public void whenAcceptChanged_then_UPDATE_1(@Payload AcceptChanged acceptChanged) {
        try {
            if (acceptChanged.isMe()) {
                // view 객체 조회
                Optional<Log> logOptional = logRepository.findById(acceptChanged.getId());
                if( logOptional.isPresent()) {
                    Log log = logOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    log.setStatus(acceptChanged.getStatus());
                    // view 레파지 토리에 save
                    logRepository.save(log);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    **/

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAcceptCanceled_then_DELETE_1(@Payload AcceptCanceled acceptCanceled) {
        try {
            if (acceptCanceled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                logRepository.deleteById(acceptCanceled.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}