package com.faik.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.faik.Controller.Impl.StudentControllerImpl;
import com.faik.Entites.Home;
import com.faik.Entites.Room;
import com.faik.Repository.AddressRepository;
import com.faik.Repository.HomeRepository;
import com.faik.Services.IHomeServices;
import com.faik.dto.DtoHome;
import com.faik.dto.DtoRoom;

@Service
public class HomeServiceImpl implements IHomeServices{
	
	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public DtoHome findHomeById(Long id) {
		DtoHome dtoHome = new DtoHome();
		Optional<Home> optional = homeRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		Home dbhome = optional.get();
		List<Room> dbRooms = optional.get().getRooms();
		
		BeanUtils.copyProperties(dbhome, dtoHome);
		if(dbRooms != null && !dbRooms.isEmpty()) {
			for (Room room : dbRooms) {
				DtoRoom dtoRoom = new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);
				dtoHome.getRooms().add(dtoRoom);
			}
		}
		return dtoHome;
	}

}
