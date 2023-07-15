 
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
import '../../styles/modalSchedule.css'
const ModalCards = (props) => {
    const {title}=props;
    const [data, setData] = useState({
      login: " ",
      city: " ",
      facility: " ",
      pickFrom: " ",
      multipleDays:false,
    });
    
    let newData = {};
  
  
  
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
    <div>
        <div className="modal-body-container mt-5">
             
             <div className="modal-card-header">
               <div>
                 <Typography component={"h4"} variant="h4">
                   {title }
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
                 <FormLabel className="mx-1">Cancel Travel</FormLabel>
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
             <div className="mt-4 ">
             <Grid container width={"97%"} margin={"auto"}>
                 <Grid item sm={6}>
                   <Grid container>
                     <Grid item sm={2}>
                       <Typography  variant="h6" textAlign={"left"}>Created By :</Typography>
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
    </div>
  )
}

export default ModalCards