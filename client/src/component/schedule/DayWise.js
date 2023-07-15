import React, { useState } from "react";
import "../../styles/schedule.css";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import {
  
  Button,
  Card,
  Grid,
  TextField,
  Typography,
} from "@mui/material";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import DayWiseCard from "./DayWiseCard";
import PickedCard from "../common/PickedCard";
const DayWise = () => {
  const [show,setShow]=useState(false)
  return (
    <div>
      <div className="daywise-header">
        <div className="daywise-header-button">
          <Button size="large">
            <ChevronLeftIcon fontSize={"large"} />
          </Button>
        </div>
        <div className="daywise-header-value" onClick={()=>setShow(!show)}>
          <Typography component={"span"} variant="h5" fontFamily={"sans-serif"}>
            Week 4
          </Typography>
        </div>
        <div className="daywise-header-button">
          <Button size="large">
            <ChevronRightIcon fontSize={"large"} />
          </Button>
        </div>
      </div>
      <div className="card-container">
        <Grid container spacing={2}>
        <Grid item sm={6}> 
        <DayWiseCard editable={false} />
        </Grid>
        <Grid item sm={6}> 
        <DayWiseCard editable={false} />
        </Grid>
        <Grid item sm={6}> 
        <DayWiseCard editable={false} />
        </Grid>
        <Grid item sm={6}> 
        <DayWiseCard editable={false} />
        </Grid>
        </Grid>
      
        {/* <DayWiseCard editable={true}/>
        <DayWiseCard  editable={false}/>
        <DayWiseCard  editable={false}/> */}
    
      </div>
      {show&&
       ( <PickedCard/>)
       }
    </div>
  );
};

export default DayWise;
