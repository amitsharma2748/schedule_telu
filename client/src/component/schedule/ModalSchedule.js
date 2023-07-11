import {
  Box,
  Button,
  InputLabel,
  MenuItem,
  Modal,
  Select,
  TextField,
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
    close(false);
  };
  const style = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 400,
    bgcolor: "background.paper",
    border: "2px solid #000",
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
        sx={{ ...style, width: "45%" }}
      >
        <div>
          <h1>Edit</h1>
          <div className="modal-dropdown-container">
            <div>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                name="route"
                value={data?.route}
                label="Route"
                onChange={(e) => handleChange(e)}
              >
                <MenuItem value=" " disabled>
                  ---select the schedule -----
                </MenuItem>
                <MenuItem value={10}>Ten</MenuItem>
                <MenuItem value={20}>Twenty</MenuItem>
                <MenuItem value={30}>Thirty</MenuItem>
              </Select>
            </div>
            <div>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                name="city"
                value={data?.city}
                label="city"
                onChange={handleChange}
              >
                <MenuItem value=" " disabled>
                  ---select the city -----
                </MenuItem>
                <MenuItem value={10}>Ten</MenuItem>
                <MenuItem value={20}>Twenty</MenuItem>
                <MenuItem value={30}>Thirty</MenuItem>
              </Select>
            </div>
          </div>
          <div className="modal-dropdown-container">
            <div>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                name="facility"
                value={data?.facility}
                label="facility"
                onChange={(e) => handleChange(e)}
              >
                <MenuItem value=" " disabled>
                  ---select the facility -----
                </MenuItem>
                <MenuItem value={10}>Ten</MenuItem>
                <MenuItem value={20}>Twenty</MenuItem>
                <MenuItem value={30}>Thirty</MenuItem>
              </Select>
            </div>
            <div className="modal-dropdown-button-container">
              <TextField
                name="specification"
                type="text"
                placeholder="Specification"
                value={data?.specification}
                onChange={(e) => handleChange(e)}
              />
            </div>
          </div>
          <div>
            <Button color="success" variant="contained">
              Sumit
            </Button>
          </div>
        </div>
      </Box>
    </Modal>
  );
};

export default ModalSchedule;
