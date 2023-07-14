import React, { useState } from "react";
import "../../styles/schedule.css";
import { Card, Grid, Typography } from "@mui/material";
import ModalSchedule from "./ModalSchedule";
import EditIcon from "@mui/icons-material/Edit";
const DayWiseCard = (props) => {
  const { editable } = props;
  const [modalOpen, setModalOpen] = useState(false);
  const modalHandler = () => {
    setModalOpen(true);
  };
  const closeModal=()=>{
    setModalOpen(false)
  }
  return (
    <Card sx={{ margin: "10px",borderRadius:"20px" }} onClick={modalHandler}>
      <div className="card-body py-3">
        <div className="card-header">
          <div className="header-date">
            <Typography component={"h4"} variant="h5" fontWeight={"700"} >Mon, 12-Jul</Typography>
          </div>
          <div className="header-icon" onClick={modalHandler}>
            <EditIcon />
          </div>
        </div>
        <Grid container className="card-body-login  p-2 rounded-pill background-light-red" width={"80%"} margin={"auto"}>
          <Grid item sm={6}  textAlign={"right"} fontFamily={'cursive'} >
            <p>Login:</p>
          </Grid>
          <Grid item sm={6} textAlign={"left"} fontFamily={'cursive'} >
            <p>OnTime</p>
          </Grid>
          </Grid>
          <Grid container  className="card-body-login mt-3 p-2 rounded-pill background-light-green"  width={"80%"} margin={"auto"}>
          <Grid item sm={6} textAlign={"right"} fontFamily={'cursive'}  >
            <p>Logout:</p>
          </Grid>
          <Grid item sm={6} textAlign={"left"} fontFamily={'cursive'}  >
            <p>Late</p>
          </Grid>
        </Grid>
      </div>

      <ModalSchedule open={modalOpen} close={closeModal} />
    </Card>
  );
};

export default DayWiseCard;
