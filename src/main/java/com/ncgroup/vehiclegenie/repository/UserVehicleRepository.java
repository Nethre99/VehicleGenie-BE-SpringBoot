package com.ncgroup.vehiclegenie.repository;

import com.ncgroup.vehiclegenie.dto.models.UserHistory;

public interface UserVehicleRepository{

    Boolean addWatchedAdds(UserHistory userHistory);

}
