package lll.whobuys.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class DeletableEntity extends ModifiableEntity{

    @CreatedDate
    @Column(name = "delete_time")
    private LocalDateTime deleteTime;

    private void checkDeletable(){
        if(deleteTime != null){
            throw new NotDeletableException();
        }
    }

    @Override
    public LocalDateTime getCreateTime() {
        return super.getCreateTime();
    }

    @Override
    public LocalDateTime getModifiedTime() {
        return super.getModifiedTime();
    }
}
