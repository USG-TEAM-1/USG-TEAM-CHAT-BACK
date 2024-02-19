package com.usg.chat.application.port.in.ChatRoom;

import java.util.List;

public interface GetChatRoomsUseCase {
    List<GetChatRoomsRes> findChatRooms(Long memberId);
}
