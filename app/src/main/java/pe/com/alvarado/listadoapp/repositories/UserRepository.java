package pe.com.alvarado.listadoapp.repositories;

import com.orm.SugarRecord;

import java.util.List;

import pe.com.alvarado.listadoapp.models.User;

/**
 * Created by Alumno on 20/04/2018.
 */

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String name, String fullname, String email, String password){
        User user = new User(name, fullname, email, password);
        SugarRecord.save(user);
    }

    public static void update(String name, String fullname, String email, String password, Long id){
        User user = SugarRecord.findById(User.class, id);
        user.setName(name);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        SugarRecord.save(user);
    }
    public static User login(String email, String password){
        List<User> users = SugarRecord.listAll(User.class);
        for (User user : users){
            if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    public static void delete(Long id){
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }

}

