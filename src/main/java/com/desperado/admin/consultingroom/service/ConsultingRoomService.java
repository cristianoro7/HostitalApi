package desperado.admin.consultingroom.service;

import java.util.List;

import desperado.admin.consultingroom.dao.ConsultingRoomDao;
import desperado.admin.consultingroom.domain.ConsultingRoomResult;
import desperado.base.Service;

/**
 * Created by desperado on 18-1-14.
 */

public class ConsultingRoomService implements Service {

    private ConsultingRoomDao consultingRoomDao;

    public ConsultingRoomService(ConsultingRoomDao consultingRoomDao) {
        this.consultingRoomDao = consultingRoomDao;
    }

    public ConsultingRoomResult addRoom(ConsultingRoomResult.ConsultingRoom room) {
        ConsultingRoomResult roomResult = new ConsultingRoomResult();
        int c = consultingRoomDao.addConsultingRoom(room);
        if (c > 0) {
            roomResult.addConsultingRoom(room);
        }
        setSuccess(roomResult);
        return roomResult;
    }

    public ConsultingRoomResult deleteRoom(int id) {
        ConsultingRoomResult roomResult = new ConsultingRoomResult();
        ConsultingRoomResult.ConsultingRoom room = consultingRoomDao.getRoomById(id);
        if (room.getLocation() != null) {
            int c = consultingRoomDao.deleteConsultingRoom(id);
            if (c > 0) {
                roomResult.addConsultingRoom(room);

            }
        }
        setSuccess(roomResult);
        return roomResult;
    }

    public ConsultingRoomResult updateRoom(ConsultingRoomResult.ConsultingRoom room) {
        ConsultingRoomResult roomResult = new ConsultingRoomResult();
        int c = consultingRoomDao.updateConsultingRoom(room);
        if (c > 0) {
            roomResult.addConsultingRoom(room);

        }
        setSuccess(roomResult);
        return roomResult;
    }

    public ConsultingRoomResult listRoomById(int id) {
        ConsultingRoomResult roomResult = new ConsultingRoomResult();
        ConsultingRoomResult.ConsultingRoom room = consultingRoomDao.getRoomById(id);
        if (room.getLocation() != null) {
            roomResult.addConsultingRoom(room);
        }
        setSuccess(roomResult);
        return roomResult;
    }

    public ConsultingRoomResult listRooms() {
        ConsultingRoomResult roomResult = new ConsultingRoomResult();
        List<ConsultingRoomResult.ConsultingRoom> list = consultingRoomDao.listRooms();
        if (list.size() > 0) {
            roomResult.addConsultingRooms(list);
        }
        setSuccess(roomResult);
        return roomResult;
    }

    public ConsultingRoomResult listRoomByDepartmentId(int departmentId) {
        ConsultingRoomResult roomResult = new ConsultingRoomResult();
        List<ConsultingRoomResult.ConsultingRoom> list = consultingRoomDao.listRoomByDepartmentId(departmentId);
        if (list.size() > 0) {
            roomResult.addConsultingRooms(list);
        }
        setSuccess(roomResult);
        return roomResult;
    }
}
