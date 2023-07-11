import React from "react";
import "../../styles/schedule.css";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import {
  Accordion,
  AccordionDetails,
  AccordionSummary,
  Button,
  Card,
  TextField,
  Typography,
} from "@mui/material";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import DayWiseCard from "./DayWiseCard";
const DayWise = () => {
  return (
    <div>
      <div className="daywise-header">
        <div className="daywise-header-button">
          <Button size="large">
            <ChevronLeftIcon fontSize={"large"} />
          </Button>
        </div>
        <div className="daywise-header-value">
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
        <DayWiseCard editable={false} />
        <DayWiseCard editable={true}/>
        <DayWiseCard  editable={false}/>
        <DayWiseCard  editable={false}/>
    
      </div>
    </div>
  );
};

export default DayWise;
