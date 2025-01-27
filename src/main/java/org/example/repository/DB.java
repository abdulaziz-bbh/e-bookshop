package org.example.repository;

import com.sun.jdi.ObjectCollectedException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.BaseDomain;
import org.example.exception.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public void update(T t, String id) {
        int index = data.indexOf(data.stream().filter(
                o -> o.getId().equals(id)).findFirst().orElseThrow(ObjectNotFoundException::new));
        data.set(index, t);
    }

    public T get(String id){
        return data.stream().filter(t1 -> Objects.equals(t1.getId(), id)).findFirst().orElseThrow(ObjectNotFoundException::new);
    }

    public List<T> getAll(){
        return data;
    }
    
    public void delete(String id){
        data.removeIf(t1 -> Objects.equals(t1.getId(), id));
    }
}
