import { Button, Grid, MenuItem, Select, TextField } from '@mui/material'
import React, { useState } from 'react'
 

const CustomForm = () => {
  const [data, setData] = useState({
    route: " ",
    city: " ",
    facility: " ",
    specification: "",
  });
  let newData = {};
  const handleChange = (event) => {
    newData[event.target.name] = event.target.value;
    setData({
      ...data,
      ...newData,
    });}
  return (
    <form>
      <Grid container textAlign={"center"} spacing={3}> 
        <Grid item sm={6}>
          <TextField type='date' size='small' fullWidth />
        </Grid>
        <Grid item sm={6}>
          <TextField type='date'  size='small' fullWidth  />
        </Grid>
        <Grid item sm={6} textAlign={"center"}>
        <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                name="route"
                size='small'
                value={data?.route}
                label="Route"
                fullWidth
                onChange={(e) => handleChange(e)}
                 
              >
                <MenuItem value=" " disabled>
                  ---select the schedule ---
                </MenuItem>
                <MenuItem value={10}>Ten</MenuItem>
                <MenuItem value={20}>Twenty</MenuItem>
                <MenuItem value={30}>Thirty</MenuItem>
              </Select>
        </Grid>
        <Grid item sm={6}>
          <Button variant='contained' color='success'>Submit Schedule</Button>
        </Grid>
      </Grid>
    </form>
  )
}

export default CustomForm