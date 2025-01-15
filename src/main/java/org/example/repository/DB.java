package org.example.repository;

import com.sun.jdi.ObjectCollectedException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.BaseDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class DB<T extends BaseDomain> {

    List<T> data = new ArrayList<>();

    public void add(T t) {
        data.add(t);
    }
    public void update(T t, UUID id) {
        int index = data.indexOf(data.stream().filter(
                o -> o.getId().equals(id)).findFirst().orElseThrow(ObjectCollectedException::new));
        data.set(index, t);
    }

    public T get(UUID id){
        return data.stream().filter(t1 -> t1.getId() == id).findFirst().orElseThrow(ObjectCollectedException::new);
    }
    
    public void delete(UUID id){
        data.removeIf(t1 -> t1.getId() == id);
    }
}
