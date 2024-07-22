<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Event extends Model
{
    use HasFactory;

    protected $primaryKey = 'eventID';

    protected $fillable = [
        'eventName', 'startTime', 'endTime', 'state', 'description', 'delflag'
    ];
}
