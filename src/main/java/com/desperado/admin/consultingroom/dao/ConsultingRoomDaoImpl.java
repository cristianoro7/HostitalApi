package desperado.admin.consultingroom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import desperado.admin.consultingroom.domain.ConsultingRoomResult;
import desperado.base.AbstractDao;

/**
 * Created by desperado on 18-1-14.
 */

public class ConsultingRoomDaoImpl extends AbstractDao implements ConsultingRoomDao {

    private static final String SQL_ADD_ROOM = "INSERT INTO consulting_room(department_id, location, create_time) " +
            "VALUES(?, ?,?);";

    private static final String SQL_DELETE_ROOM = "DELETE from consulting_room " +
            "WHERE consulting_room_id = ?;";

    private static final String SQL_QUERY_ROOM = "SELECT consulting_room_id, department_id, location " +
            "FROM consulting_room " +
            "WHERE consulting_room_id = ?;";

    private static final String SQL_QUERY_ROOMS = "SELECT consulting_room_id, department_id, location " +
            "FROM consulting_room;";

    private static final String SQL_UPDATE_ROOM = "UPDATE consulting_room SET " +
            "department_id = ?, location = ?, modified_time = ? " +
            "WHERE consulting_room_id = ?;";

    private static final String SQL_QUERY_ROOM_BY_DEPARTMENT_ID = "SELECT consulting_room_id, department_id, location " +
            "FROM consulting_room " +
            "WHERE department_id = ?;";

    @Override
    public int deleteConsultingRoom(int id) {
        return delete(SQL_DELETE_ROOM, new Object[]{id});
    }

    @Override
    public int updateConsultingRoom(ConsultingRoomResult.ConsultingRoom room) {
        return update(SQL_UPDATE_ROOM, new Object[]{Integer.parseInt(room.getDepartmentId()),
                room.getLocation(), new Timestamp(System.currentTimeMillis()),
                Integer.parseInt(room.getId())});
    }

    @Override
    public int addConsultingRoom(ConsultingRoomResult.ConsultingRoom room) {
        return insert(SQL_ADD_ROOM, new Object[]{Integer.parseInt(room.getDepartmentId()),
                room.getLocation(), new Timestamp(System.currentTimeMillis())});
    }

    @Override
    public ConsultingRoomResult.ConsultingRoom getRoomById(int id) {
        ConsultingRoomResult.ConsultingRoom room = new ConsultingRoomResult.ConsultingRoom();
        query(SQL_QUERY_ROOM, new Object[]{id}, resultSet -> {
            room.setId(String.valueOf(resultSet.getInt(1)));
            room.setDepartmentId(String.valueOf(resultSet.getInt(2)));
            room.setLocation(resultSet.getString(3));
        });
        return room;
    }

    @Override
    public List<ConsultingRoomResult.ConsultingRoom> listRooms() {
        List<ConsultingRoomResult.ConsultingRoom> list = new ArrayList<>();
        query(SQL_QUERY_ROOMS, null, resultSet -> {
            setResult(list, resultSet);
        });
        return list;
    }

    @Override
    public List<ConsultingRoomResult.ConsultingRoom> listRoomByDepartmentId(int departmentId) {
        List<ConsultingRoomResult.ConsultingRoom> list = new ArrayList<>();
        query(SQL_QUERY_ROOM_BY_DEPARTMENT_ID, new Object[]{departmentId}, resultSet -> {
            setResult(list, resultSet);
        });
        return list;
    }

    private void setResult(List<ConsultingRoomResult.ConsultingRoom> modifiedList, ResultSet resultSet) throws SQLException {
        ConsultingRoomResult.ConsultingRoom room = new ConsultingRoomResult.ConsultingRoom();
        room.setId(String.valueOf(resultSet.getInt(1)));
        room.setDepartmentId(String.valueOf(resultSet.getInt(2)));
        room.setLocation(resultSet.getString(3));
        modifiedList.add(room);
    }
}
