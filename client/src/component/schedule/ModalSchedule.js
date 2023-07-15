import {
  Box,
  Button,
  Checkbox,
  FormLabel,
  Grid,
  InputLabel,
  MenuItem,
  Modal,
  Select,
  TextField,
  Typography,
} from "@mui/material";
import React, { useState } from "react";
import CloseIcon from "@mui/icons-material/Close";
import "../../styles/modalSchedule.css";
import ModalCards from "../common/ModalCardsSchedule";
const ModalSchedule = (props) => {
  const { open, close } = props;
 
  const [data, setData] = useState({
    login: " ",
    city: " ",
    facility: " ",
    pickFrom: " ",
    multipleDays:false,
  });
  
  let newData = {};
  const handleClose = () => {
    console.log(close)
    close();
  };
  const style = {
    position: "absolute",
    overflow:"scroll",    
    height: "100%",
    width: "100%",
    bgcolor: "background.paper",
    borderRadius: 2,
    boxShadow: 24,
    pt: 2,
    px: 4,
    pb: 3,
  };

  const handleChange = (event) => {
    if(event.target.name==='multipleDays'){
      newData[event.target.name] = event.target.checked;
    }
    else{
      newData[event.target.name] = event.target.value;
    }
    
    setData({
      ...data,
      ...newData,
    });
    console.log(data, newData);
  };
  return (
    <Modal
      open={open}
      onClose={handleClose}
      aria-labelledby="parent-modal-title"
      aria-describedby="parent-modal-description"
      className="modal-schedule"
    >
      <Box
        component={"div"}
        className="modal-schedule-container"
        sx={{ ...style }}
      >
        <div className="modal-close-container" onClick={handleClose}>
          <CloseIcon />
        </div>
        <div className="modal-schedule-header">
          <p>Heading</p>
        </div>
        <div className="modal-schedule-date" >
          <Typography component={"h6"} variant="h6" fontSize={"16px"}>
            Mon, 12-Jul
          </Typography>
        </div>
        <div className="modal-schedule-body">
          <div className="modal-body-container">
            <div className="modal-card-header">
              <div>
                <Typography component={"h4"} variant="h4">
                  Pick
                </Typography>
              </div>
              <div>
                <Typography component={"p"} variant="p">
                  Commute By: Cab
                </Typography>
              </div>
              <div>
              <Checkbox
                   label="Cancel Travel"
                   color="error"
                   sx={{
                    transform: "scale(1.1)"
                   }} 
                   checkedIcon={
                     <CloseIcon
                     fontSize="small"
                     sx={{
                      border: "0.5px solid black",
                   
                    }}
                     />
                   }
                   defaultChecked
                 />
                <FormLabel>Cancel Travel</FormLabel>
              </div>
            </div>
            <div className="modal-dropdown-card">
              <div>
              <InputLabel id="demo-simple-select-helper-label" sx={{marginLeft:"2%",fontSize:"22px"}}>City</InputLabel>
                <Select
                   labelId="demo-simple-select-helper-label"
                  id="demo-simple-select"
                  name="city"
                  value={data?.city}
                  label="city"
                  onChange={handleChange}
                  sx={{backgroundColor:"#A1CCD1"}}
                  fullWidth
                >
                  <MenuItem value=" " disabled>
                    ---select the city -----
                  </MenuItem>
                  <MenuItem value={10}>Ten</MenuItem>
                  <MenuItem value={20}>Twenty</MenuItem>
                  <MenuItem value={30}>Thirty</MenuItem>
                </Select>
              </div>
              <div>
              <InputLabel id="demo-simple-select-helper-label" sx={{marginLeft:"2%",fontSize:"22px"}}>Facility</InputLabel>
                <Select
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  name="facility"
                  value={data?.facility}
                  label="facility"
                  onChange={(e) => handleChange(e)}
                  sx={{backgroundColor:"#A1CCD1"}}
                  fullWidth
                >
                  <MenuItem value=" " disabled>
                    ---select the facility -----
                  </MenuItem>
                  <MenuItem value={10}>Ten</MenuItem>
                  <MenuItem value={20}>Twenty</MenuItem>
                  <MenuItem value={30}>Thirty</MenuItem>
                </Select>
              </div>
            </div>
            <div className="modal-dropdown-card">
              <div>
              <InputLabel id="demo-simple-select-helper-label" sx={{marginLeft:"2%",fontSize:"22px"}}>Login</InputLabel>
                <Select
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  name="login"
                  value={data?.login}
                  label="login"
                  onChange={handleChange}
                  sx={{backgroundColor:"#A1CCD1"}}
                  fullWidth
                >
                  <MenuItem value=" " disabled>
                    ---select the Login -----
                  </MenuItem>
                  <MenuItem value={10}>Ten</MenuItem>
                  <MenuItem value={20}>Twenty</MenuItem>
                  <MenuItem value={30}>Thirty</MenuItem>
                </Select>
              </div>
              <div>
              <InputLabel id="demo-simple-select-helper-label" sx={{marginLeft:"2%",fontSize:"22px"}}>Pick From</InputLabel>
                <Select
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  name="pickFrom"
                  value={data?.pickFrom}
                  label="pickFrom"
                  onChange={handleChange}
                  sx={{backgroundColor:"#A1CCD1"}}
                  fullWidth
                >
                  <MenuItem value=" " disabled>
                    --- Pick From -----
                  </MenuItem>
                  <MenuItem value={10}>Ten</MenuItem>
                  <MenuItem value={20}>Twenty</MenuItem>
                  <MenuItem value={30}>Thirty</MenuItem>
                </Select>
              </div>
             
            </div>
            <div>
            <Grid container width={"97%"} margin={"auto"}>
                <Grid item sm={6}>
                  <Grid container>
                    <Grid item sm={2}>
                      <Typography variant="h6" textAlign={"left"}>Created By :</Typography>
                    </Grid>
                    <Grid item sm={10}>
                      <Typography variant="h6" textAlign={"left"}>XYZ</Typography>
                    </Grid>
                  </Grid>
                </Grid>
                <Grid item sm={6}>
                  <Grid container>
                    <Grid item sm={2}>
                      <Typography variant="h6" textAlign={"left"}>Modified By :</Typography>
                    </Grid>
                    <Grid item sm={10}>
                      <Typography variant="h6" textAlign={"left"}>XYZ</Typography>
                    </Grid>
                  </Grid>
                </Grid>
                <Grid item sm={6}>
                  <Grid container>
                    <Grid item sm={2}>
                      <Typography variant="h6" textAlign={"left"}>Created on :</Typography>
                    </Grid>
                    <Grid item sm={10}>
                      <Typography variant="h6" textAlign={"left"}>XYZ</Typography>
                    </Grid>
                  </Grid>
                </Grid>
                <Grid item sm={6}>
                  <Grid container>
                    <Grid item sm={2}>
                      <Typography variant="h6" textAlign={"left"}>Modified on :</Typography>
                    </Grid>
                    <Grid item sm={10}>
                      <Typography variant="h6" textAlign={"left"}>XYZ</Typography>
                    </Grid>
                  </Grid>
                </Grid>
              </Grid>

            </div>
          </div>
          <div className="modal-body-container mt-5">
             
            <div className="modal-card-header">
              <div>
                <Typography component={"h4"} variant="h4">
                  Drop
                </Typography>
              </div>
              <div>
                <Typography component={"p"} variant="p">
                  Commute By: Bus
                </Typography>
              </div>
              <div>
              <Checkbox
                   label="Cancel Travel"
                   color="error"
                   sx={{
                    transform: "scale(1.1)"
                   }} 
                   checkedIcon={
                     <CloseIcon
                     fontSize="small"
                     sx={{
                      border: "0.5px solid black",
                   
                    }}
                     />
                   }
                   defaultChecked
                 />
                <FormLabel>Cancel Travel</FormLabel>
              </div>
            </div>
            <div className="modal-dropdown-card">
              <div>
              <InputLabel id="demo-simple-select-helper-label" sx={{marginLeft:"2%",fontSize:"22px"}}>City</InputLabel>
                <Select
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  name="city"
                  value={data?.city}
                  label="city"
                  onChange={handleChange}
                  sx={{backgroundColor:"#A1CCD1"}}
                  fullWidth
                >
                  <MenuItem value=" " disabled>
                    ---select the city -----
                  </MenuItem>
                  <MenuItem value={10}>Ten</MenuItem>
                  <MenuItem value={20}>Twenty</MenuItem>
                  <MenuItem value={30}>Thirty</MenuItem>
                </Select>
              </div>
              <div>
              <InputLabel id="demo-simple-select-helper-label" sx={{marginLeft:"2%",fontSize:"22px"}}>Facility</InputLabel>
                <Select
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  name="facility"
                  value={data?.facility}
                  label="facility"
                  onChange={(e) => handleChange(e)}
                  sx={{backgroundColor:"#A1CCD1"}}
                  fullWidth
                >
                  <MenuItem value=" " disabled>
                    ---select the facility -----
                  </MenuItem>
                  <MenuItem value={10}>Ten</MenuItem>
                  <MenuItem value={20}>Twenty</MenuItem>
                  <MenuItem value={30}>Thirty</MenuItem>
                </Select>
              </div>
            </div>
            <div className="modal-dropdown-card">
              <div>
              <InputLabel id="demo-simple-select-helper-label" sx={{marginLeft:"2%",fontSize:"22px"}}>Login</InputLabel>
                <Select
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  name="login"
                  value={data?.login}
                  label="login"
                  onChange={handleChange}
                  sx={{backgroundColor:"#A1CCD1"}}
                  fullWidth
                >
                  <MenuItem value=" " disabled>
                    ---select the Login -----
                  </MenuItem>
                  <MenuItem value={10}>Ten</MenuItem>
                  <MenuItem value={20}>Twenty</MenuItem>
                  <MenuItem value={30}>Thirty</MenuItem>
                </Select>
              </div>
              <div>
              <InputLabel id="demo-simple-select-helper-label" sx={{marginLeft:"2%",fontSize:"22px"}}>Pick From</InputLabel>
                <Select
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  name="pickFrom"
                  value={data?.pickFrom}
                  label="pickFrom"
                  onChange={handleChange}
                  sx={{backgroundColor:"#A1CCD1"}}
                  fullWidth
                >
                  <MenuItem value=" " disabled>
                    --- Pick From -----
                  </MenuItem>
                  <MenuItem value={10}>Ten</MenuItem>
                  <MenuItem value={20}>Twenty</MenuItem>
                  <MenuItem value={30}>Thirty</MenuItem>
                </Select>
              </div>        
            </div>
            <div className="mt-4 ">
            <Grid container width={"97%"} margin={"auto"}>
                <Grid item sm={6}>
                  <Grid container>
                    <Grid item sm={2}>
                      <Typography variant="h6" textAlign={"left"}>Created By :</Typography>
                    </Grid>
                    <Grid item sm={10}>
                      <Typography variant="h6" textAlign={"left"}>XYZ</Typography>
                    </Grid>
                  </Grid>
                </Grid>
                <Grid item sm={6}>
                  <Grid container>
                    <Grid item sm={2}>
                      <Typography variant="h6" textAlign={"left"}>Modified By :</Typography>
                    </Grid>
                    <Grid item sm={10}>
                      <Typography variant="h6" textAlign={"left"}>XYZ</Typography>
                    </Grid>
                  </Grid>
                </Grid>
                <Grid item sm={6}>
                  <Grid container>
                    <Grid item sm={2}>
                      <Typography variant="h6" textAlign={"left"}>Created on :</Typography>
                    </Grid>
                    <Grid item sm={10}>
                      <Typography variant="h6" textAlign={"left"}>XYZ</Typography>
                    </Grid>
                  </Grid>
                </Grid>
                <Grid item sm={6}>
                  <Grid container>
                    <Grid item sm={2}>
                      <Typography variant="h6" textAlign={"left"}>Modified on :</Typography>
                    </Grid>
                    <Grid item sm={10}>
                      <Typography variant="h6" textAlign={"left"}>XYZ</Typography>
                    </Grid>
                  </Grid>
                </Grid>
              </Grid>

            </div>    
        </div>
        <div className="p-7 mt-5">
                  <div className="d-flex align-items-center">
                    <Checkbox aria-label="Multiple times" name="multipleDays" checked={data?.multipleDays} onChange={handleChange}/>
                    <InputLabel>Schedule me for multiple times during day</InputLabel>
                  </div>
        </div>
        {data?.multipleDays&&<div className="schedule-multiple-times">
              <ModalCards title='RePick'/>
              <ModalCards title='ReDrop'/>
        </div>}
        </div>
        
      </Box>
    </Modal>
  );
};

export default ModalSchedule;
