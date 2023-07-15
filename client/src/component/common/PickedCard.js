import {
  Box,
  Button,
  Checkbox,
  FormLabel,
  Grid,
  Typography,
} from "@mui/material";
import ReactStars from 'react-stars'
import React, { useState } from "react";
 import "../../styles/modalSchedule.css";

const PickedCard = () => {
 
 

 
  return (
    <div className="modal-schedule-body">
      <div className="modal-body-container mt-5">
        <div className="modal-card-header">
          <div>
            <Typography component={"h4"} variant="h4">
              title
            </Typography>
          </div>
          <div>
            <Typography component={"p"} variant="p">
              Commute By: Bus
            </Typography>
          </div>
          <div>
            <Typography component={"p"} variant="p">
              Route No: 1234
            </Typography>
          </div>
        </div>
        <div className="modal-dropdown-card">
          <div className="d-flex flex-column">
            <div>
              <h6>Vehicle</h6>
            </div>
            <div>
              <h3>HR11AA1122</h3>
            </div>
          </div>
          <div className="d-flex flex-column">
            <div>
              <h6>Driver</h6>
            </div>
            <div>
              <h3>Dheeraj Kumar</h3>
            </div>
          </div>
          <div className="d-flex flex-column">
            <div>
              <h6>Vendor</h6>
            </div>
            <div>
              <h3>GTT</h3>
            </div>
          </div>
        </div>
        <div className="modal-dropdown-card">
          <div className="d-flex flex-column">
            <div>
              <h5>Boarding Status</h5>
            </div>
            <div className="bg-success py-2 rounded">
              <h2>Picked</h2>
            </div>
          </div>
          <div className="d-flex flex-column">
            <div>
              <div>
                <p>Scheduled Time</p>
              </div>
              <div>
                <h5>07:00 Hrs</h5>
              </div>
            </div>
            <div>
              <div>
                <p>Actual Pick Time</p>
              </div>
              <div>
                <h5>06:49 Hrs</h5>
              </div>
            </div>
            <div>
              <div>
                <p>Scheduled Time</p>
              </div>
              <div>
                <h5>07:00 Hrs</h5>
              </div>
            </div>
          </div>
        </div>
        <div className="modal-dropdown-card">
          <div className="d-flex align-items-center">
            <div>
              <h5>Provide Feedback</h5>
            </div>
            <div>
              <ReactStars
                count={5}
                size={44}
                color2={"#ffd700"}
              />
            </div>
          </div>
        </div>
         
      </div>
    </div>
  );
};

export default PickedCard;
