import {
  Box,
  Button,
  Grid,
  InputLabel,
  MenuItem,
  Modal,
  Select,
  TextField,
  Typography,
} from "@mui/material";
import React, { useState } from "react";
import "../../styles/modalSchedule.css";
const ModalSchedule = (props) => {
  const { open, close } = props;
  const [data, setData] = useState({
    route: " ",
    city: " ",
    facility: " ",
    specification: "",
  });
  let newData = {};
  const handleClose = () => {
    close();
  };
  const style = {
    position: "absolute",
     
    height:"100%",
    width: "100%",
    
    bgcolor: "background.paper",
    borderRadius:2,
    boxShadow: 24,
    pt: 2,
    px: 4,
    pb: 3,
  };

  const handleChange = (event) => {
    newData[event.target.name] = event.target.value;
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
        <div>
          
        </div>
        <Grid container spacing={2} textAlign={"center"}>
          <Grid item sm={12}   >
          <Typography variant="h6">Edit</Typography>
          </Grid>
          
          <Grid item md={12} lg={6}  >
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                name="route"
                value={data?.route}
                label="Route"
                onChange={(e) => handleChange(e)}
                fullWidth
              >
                <MenuItem value=" " disabled>
                  ---select the schedule ---
                </MenuItem>
                <MenuItem value={10}>Ten</MenuItem>
                <MenuItem value={20}>Twenty</MenuItem>
                <MenuItem value={30}>Thirty</MenuItem>
              </Select>
              </Grid>
              <Grid item md={12} lg={6}>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                name="city"
                value={data?.city}
                label="city"
                onChange={handleChange}
                fullWidth
              >
                <MenuItem value=" " disabled>
                  ---select the city -----
                </MenuItem>
                <MenuItem value={10}>Ten</MenuItem>
                <MenuItem value={20}>Twenty</MenuItem>
                <MenuItem value={30}>Thirty</MenuItem>
              </Select>
              </Grid>
              <Grid item md={12} lg={6}>
           <TextField
                name="specific-request"
                type="text"
                placeholder="Specific Request"
                value={data?.specification}
                onChange={(e) => handleChange(e)}
                fullWidth
              />
           </Grid>
              <Grid item md={12} lg={6}>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                name="facility"
                value={data?.facility}
                label="facility"
                onChange={(e) => handleChange(e)}
                fullWidth
              >
                <MenuItem value=" " disabled>
                  ---select the facility -----
                </MenuItem>
                <MenuItem value={10}>Ten</MenuItem>
                <MenuItem value={20}>Twenty</MenuItem>
                <MenuItem value={30}>Thirty</MenuItem>
              </Select>
           </Grid>
      
            
           <Grid item sm={12}  >
           <Button color="success" variant="contained" size="large">
              Sumit
            </Button>
           </Grid>
           
          
        </Grid>
      </Box>
    </Modal>
  );
};

export default ModalSchedule;
